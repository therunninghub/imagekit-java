package io.imagekit.sdk.models.results;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.imagekit.sdk.models.BaseFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultList {
    private boolean isSuccessful;
    private String message;
    private String help;
    private String raw;
    private List<BaseFile> results;

    public ResultList() {

    }

    public ResultList(List<BaseFile> results) {
        this.results = results;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public List<Map<String, Object>> getMap() {
        if (null != raw) {
            return new Gson().fromJson(raw, new TypeToken<List<Map<String, Object>>>() {
            }.getType());
        }
        return new ArrayList<>();
    }

    public List<BaseFile> getResults() {
        return results;
    }

    public void setResults(List<BaseFile> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ResultList{" +
                "isSuccessful=" + isSuccessful +
                ", message='" + message + '\'' +
                ", help='" + help + '\'' +
                ", results=" + results +
                '}';
    }
}
