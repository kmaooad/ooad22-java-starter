package edu.kmaooad;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class ExampleDependencyImpl implements ExampleDependency {

    @Override
    public long getSomeNumber() {
        return new Date().getTime();
    }
}