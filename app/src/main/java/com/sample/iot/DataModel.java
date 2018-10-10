package com.sample.iot;

public class DataModel {
    private String time;
    private String setpoint;
    private String process_variable;
    private String controller_output;

    public DataModel() {
    }

    public DataModel(String time, String setpoint, String process_variable, String controller_output) {
        this.time = time;
        this.setpoint = setpoint;
        this.process_variable = process_variable;
        this.controller_output = controller_output;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSetpoint() {
        return setpoint;
    }

    public void setSetpoint(String setpoint) {
        this.setpoint = setpoint;
    }

    public String getProcess_variable() {
        return process_variable;
    }

    public void setProcess_variable(String process_variable) {
        this.process_variable = process_variable;
    }

    public String getController_output() {
        return controller_output;
    }

    public void setController_output(String controller_output) {
        this.controller_output = controller_output;
    }
}