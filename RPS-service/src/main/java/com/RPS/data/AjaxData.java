package com.RPS.data;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/9.
 */
public class AjaxData<T> {
    private boolean state;//消息状态
    private String msg;//消息
    private Map<String,Object> single;//map数据
    private List<T> result;//list数据
    private Object obj;//单个对象数据
    private PaginationData paginationData;//分页数据

    public AjaxData<T> success(){
        this.state = true;
        return this;
    }

    public AjaxData<T> fail(){
        this.state = false;
        return this;
    }

    public AjaxData<T> msg(String msg){
        this.msg = msg;
        return this;
    }

    public AjaxData<T> obj(Object obj){
        this.obj = obj;
        return this;
    }

    public AjaxData<T> mapData(Map<String,Object> map){
        this.single = map;
        return this;
    }

    public AjaxData<T> listData(List<T> list){
        this.result = list;
        return this;
    }

    public AjaxData<T> paginationData(PaginationData paginationData){
        this.paginationData = paginationData;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public PaginationData getPaginationData() {
        return paginationData;
    }

    public void setPaginationData(PaginationData paginationData) {
        this.paginationData = paginationData;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Map<String, Object> getSingle() {
        return single;
    }

    public void setSingle(Map<String, Object> single) {
        this.single = single;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "AjaxData{" +
                "state=" + state +
                ", msg='" + msg + '\'' +
                ", single=" + single +
                ", result=" + result +
                ", obj=" + obj +
                ", paginationData=" + paginationData +
                '}';
    }
}
