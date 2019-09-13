package me.zhyd.oauth.model;

import lombok.Builder;
import lombok.Getter;
import me.zhyd.oauth.enums.AuthResponseStatus;

/**
 * JustAuth统一授权响应类
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @since 1.8
 */

public class AuthResponse<T> {
    public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
     * 授权响应状态码
     */
    private int code;

    /**
     * 授权响应信息
     */
    private String msg;

    /**
     * 授权响应数据，当且仅当 code = 2000 时返回
     */
    private T data;

    /**
     * 是否请求成功
     *
     * @return true or false
     */
    public boolean ok() {
        return this.code == AuthResponseStatus.SUCCESS.getCode();
    }
}
