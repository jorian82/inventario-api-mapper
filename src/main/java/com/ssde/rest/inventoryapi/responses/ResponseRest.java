package com.ssde.rest.inventoryapi.responses;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jorian, SSDE Inc
 * on Fri, Mar 29 2024
 * at 13:42, inventory-api
 */
@Getter
public class ResponseRest {

    private final ArrayList<HashMap<String, String>> metadata = new ArrayList<>();

    public void setMetadata(String type, String code, String data) {
        HashMap<String, String> map = new HashMap<>();

        map.put("type", type);
        map.put("code", code);
        map.put("data", data);

        metadata.add(map);
    }
}
