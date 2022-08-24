
package com.hr.beetestapp.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {
    private List<Payload> payload;

    public Result(List<Payload> payload) {
        this.payload = payload;
    }

    public List<Payload> getPayload() {
        return payload;
    }

    public void setPayload(List<Payload> payload) {
        this.payload = payload;
    }
}
