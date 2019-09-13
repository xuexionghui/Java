package me.zhyd.oauth.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 授权回调时的参数类
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @since 1.8.0
 */

public class AuthCallback {

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAuth_code() {
		return auth_code;
	}

	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAuthorization_code() {
		return authorization_code;
	}

	public void setAuthorization_code(String authorization_code) {
		this.authorization_code = authorization_code;
	}

	/**
     * 访问AuthorizeUrl后回调时带的参数code
     */
    private String code;

    /**
     * 访问AuthorizeUrl后回调时带的参数auth_code，该参数目前只使用于支付宝登录
     */
    private String auth_code;

    /**
     * 访问AuthorizeUrl后回调时带的参数state，用于和请求AuthorizeUrl前的state比较，防止CSRF攻击
     */
    private String state;

    /**
     * 华为授权登录接受code的参数名
     *
     * @since 1.10.0
     */
    private String authorization_code;
}
