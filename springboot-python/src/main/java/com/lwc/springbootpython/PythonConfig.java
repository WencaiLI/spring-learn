package com.lwc.springbootpython;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PythonConfig {
    @Value("${python.file.main}")
    public String pythonFileMain;
}