//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lwc;

public class JsonResult<T> {
    private Integer code;
    private String status;
    private T data;
    private String description;

    public static <T> JsonResult<T> querySuccess(T data) {
        return new JsonResult(200, "success", data, "");
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult(200, "success", data, "操作成功");
    }

    public static <T> JsonResult<T> success(T data, String msg) {
        return new JsonResult(200, "success", data, msg);
    }

    public static <T> JsonResult<T> success() {
        return new JsonResult(200, "success", (Object)null, "操作成功");
    }

    public static <T> JsonResult<String> error(Integer code, String data) {
        return new JsonResult(code, "error", data, "description");
    }

    public static <T> JsonResult<String> error(Integer code, String data, String description) {
        return new JsonResult(code, "error", data, description);
    }

    public static <T> JsonResult<T> error(String description) {
        return new JsonResult(500, "error", (Object)null, description);
    }

    public static <T> JsonResultBuilder<T> builder() {
        return new JsonResultBuilder();
    }

    public Integer getCode() {
        return this.code;
    }

    public String getStatus() {
        return this.status;
    }

    public T getData() {
        return this.data;
    }

    public String getDescription() {
        return this.description;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof JsonResult)) {
            return false;
        } else {
            JsonResult<?> other = (JsonResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label59;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label59;
                    }

                    return false;
                }

                Object this$status = this.getStatus();
                Object other$status = other.getStatus();
                if (this$status == null) {
                    if (other$status != null) {
                        return false;
                    }
                } else if (!this$status.equals(other$status)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                Object this$description = this.getDescription();
                Object other$description = other.getDescription();
                if (this$description == null) {
                    if (other$description != null) {
                        return false;
                    }
                } else if (!this$description.equals(other$description)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof JsonResult;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        Object $description = this.getDescription();
        result = result * 59 + ($description == null ? 43 : $description.hashCode());
        return result;
    }

    public String toString() {
        return "JsonResult(code=" + this.getCode() + ", status=" + this.getStatus() + ", data=" + this.getData() + ", description=" + this.getDescription() + ")";
    }

    public JsonResult(Integer code, String status, T data, String description) {
        this.code = code;
        this.status = status;
        this.data = data;
        this.description = description;
    }

    public JsonResult() {
    }

    public static class JsonResultBuilder<T> {
        private Integer code;
        private String status;
        private T data;
        private String description;

        JsonResultBuilder() {
        }

        public JsonResultBuilder<T> code(Integer code) {
            this.code = code;
            return this;
        }

        public JsonResultBuilder<T> status(String status) {
            this.status = status;
            return this;
        }

        public JsonResultBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public JsonResultBuilder<T> description(String description) {
            this.description = description;
            return this;
        }

        public JsonResult<T> build() {
            return new JsonResult(this.code, this.status, this.data, this.description);
        }

        public String toString() {
            return "JsonResult.JsonResultBuilder(code=" + this.code + ", status=" + this.status + ", data=" + this.data + ", description=" + this.description + ")";
        }
    }
}
