Springboot集成minio实现文件存储的实现代码
2022-09-24 14:38、楽. Java教程

MinIO 是一款基于Go语言的高性能对象存储服务，本文主要介绍了Springboot集成minio实现文件存储的实现代码，文中通过示例代码介绍的非常详细，具有一定的参考价值，感兴趣的小伙伴们可以参考一下

在我们平时做项目的时候，文件存储是个很常见的需求。这时候我们就会用到对象存储服务，平时我们可能会选择OSS、AWS S3这类第三方服务。今天带大家搭建一款自己的对象存储服务，带可视化管理，用起来也挺简单。

MinIO 是一款基于Go语言的高性能对象存储服务，它采用了Apache License v2.0开源协议，非常适合于存储大容量非结构化的数据，例如图片、视频、日志文件、备份数据和容器/虚拟机镜像等。

 

1. 安装部署
 

1.1 Linux 简单部署
wget https://dl.min.io/server/minio/release/linux-amd64/minio

chmod +x minio 

MINIO_ROOT_USER=admin MINIO_ROOT_PASSWORD=123456 

##启动并指定端口
./minio server /mnt/data --console-address ":9001"

## 或者后台启动
nohup ./minio server /mnt/data  >  /opt/minio/minio.log 2>&1 &#
Springboot集成minio实现文件存储的实现代码

然后访问对应地址即可：云服务器的话记得去安全组打开对应端口，账号密码如图所示：

Springboot集成minio实现文件存储的实现代码

 

1.2 Docker 部署
#下载MinIO的Docker镜像 
docker pull minio/minio 
#--console-address指定MinIO Console的运行端口 （否则会随机端口运行） 暴露端口9001或者9000 
docker run -p 9090:9000 -p 9001:9001 --name minio  -v /mydata/minio/data:/data  -e MINIO_ROOT_USER=minioadmin  -e MINIO_ROOT_PASSWORD=minioadmin  -d minio/minio server /data --console-address ":9001"
 

2. Spring boot 整合
添加相关依赖

<!--        引入minio依赖-->
<dependency>
    <groupId>io.minio</groupId>
    <artifactId>minio</artifactId>
    <version>8.0.3</version>
</dependency>
添加相关配置信息

默认安装不指定Access key 和Secret key 的话都是minioadmin, Endpoint则为服务器API地址.

spring:
  # 配置文件上传大小限制
  servlet:
    multipart:
      max-file-size: 100MB
      max-request-size: 100MB

# minio 参数配置
minio:
  endpoint: http://127.0.01:9090
  accessKey: minioadmin
  secretKey: minioadmin
注入客户端

将客户端注入Spring容器中，使用的时候直接获取即可。
```java
@Configuration
public class MinIoConfig {

    @Value("${minio.endpoint}")
    private String endpoint;
    @Value("${minio.accessKey}")
    private String accessKey;
    @Value("${minio.secretKey}")
    private String secretKey;

    /**
     * 注入minio 客户端
     *
     * @return
     */
    @Bean
    public MinioClient minioClient() {

        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }
}
```

编写相关业务代码

编写相关业务代码，上传图片后将相关的路径回传。
```java
/**
 * 文件上传 （自定义文件名称）
 */
public MinIoUploadVo upload(String strDir, MultipartFile multipartFile) throws Exception {

    // bucket 不存在，创建
    if (!this.bucketExists(strDir)) {
        this.makeBucket(strDir);
    }
    InputStream inputStream = multipartFile.getInputStream();
    // 创建一个 headers
    Map<String, String> headers = new HashMap<>();
    // 添加请求头 文件的ContentType 动态配置 multipartFile.getContentType()
    headers.put("Content-Type", "application/octet-stream");

    String fileName = multipartFile.getOriginalFilename();

    String minFileName = minFileName(fileName);
    instance.putObject(
            PutObjectArgs.builder().bucket(strDir).object(minFileName).stream(
                    inputStream, inputStream.available(), -1) // PutObjectOptions，上传配置(文件大小，内存中文件分片大小)
                    .headers(headers)
                    .build());
    String url = endpoint.concat("/").concat(strDir).concat("/").concat(minFileName);
    // 返回生成文件名、访问路径
    return new MinIoUploadVo(strDir, fileName, minFileName, url);
}
```
上传文件接口
```java
@RequestMapping(value = "/upload", method = RequestMethod.POST)
public R upload(MultipartFile file, HttpServletRequest request) throws IOException {
    String strDir = request.getParameter("bucketName") == null ? "car" : request.getParameter("bucketName");

    try {
        MinIoUploadVo uploadVo = minioService.upload(strDir, file);
        return R.ok().message("文件上传成功").data(uploadVo);
    } catch (Exception e) {
        log.error("上传文件失败，msg={}", e.getMessage());
        e.printStackTrace();
        return R.error();
    }
}

```
测试相关接口

Springboot集成minio实现文件存储的实现代码

如果不能访问该地址 ，记得去开启相关权限。

Springboot集成minio实现文件存储的实现代码

 

3. 问题记录
S3 API Request made to Console port. S3 Requests should be sent to API port.

Springboot集成minio实现文件存储的实现代码

原因是配置文件里面用了Console 控制台的端口，应该使用API端口：

Springboot集成minio实现文件存储的实现代码

 

4. 项目地址
更多Demo案例可以前往我的个人仓库查看 正在逐步更新中。

https://gitee.com/cl1429745331/java-coder

到此这篇关于Springboot集成minio实现文件存储的实现代码的文章就介绍到这了,更多相关Springboot minio文件存储内容请搜索服务器之家以前的文章或继续浏览下面的相关文章希望大家以后多多支持服务器之家！

原文地址：https://blog.csdn.net/qq_41432730/article/details/123451749

