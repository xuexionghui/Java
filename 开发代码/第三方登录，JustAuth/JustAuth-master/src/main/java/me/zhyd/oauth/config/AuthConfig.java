package me.zhyd.oauth.config;

import lombok.*;

/**
 * JustAuth配置类
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @since 1.8
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthConfig {

    /**
     * 客户端id：对应各平台的appKey
     */
    private String clientId;

    /**
     * 客户端Secret：对应各平台的appSecret
     */
    private String clientSecret;

    /**
     * 登录成功后的回调地址
     */
    private String redirectUri;

    /**
     * 支付宝公钥：当选择支付宝登录时，该值可用
     */
    private String alipayPublicKey;

    public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getAlipayPublicKey() {
		return alipayPublicKey;
	}

	public void setAlipayPublicKey(String alipayPublicKey) {
		this.alipayPublicKey = alipayPublicKey;
	}

	public boolean isUnionId() {
		return unionId;
	}

	public void setUnionId(boolean unionId) {
		this.unionId = unionId;
	}

	public String getStackOverflowKey() {
		return stackOverflowKey;
	}

	public void setStackOverflowKey(String stackOverflowKey) {
		this.stackOverflowKey = stackOverflowKey;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	/**
     * 是否需要申请unionid，目前只针对qq登录
     * 注：qq授权登录时，获取unionid需要单独发送邮件申请权限。如果个人开发者账号中申请了该权限，可以将该值置为true，在获取openId时就会同步获取unionId
     * 参考链接：http://wiki.connect.qq.com/unionid%E4%BB%8B%E7%BB%8D
     * <p>
     * 1.7.1版本新增参数
     */
    private boolean unionId;

    /**
     * Stack Overflow Key
     * <p>
     *
     * @since 1.9.0
     */
    private String stackOverflowKey;

    /**
     * 企业微信，授权方的网页应用ID
     *
     * @since 1.10.0
     */
    private String agentId;
}
