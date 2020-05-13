package api.entity;

import api.annotion.API;
import api.annotion.APIField;
import lombok.Data;

@API(url = "/creatTicket", desc = "创建票据接口", type = "GET")
@Data
public class CreateTicketAPI extends AbstractAPI{
	
	@APIField(isRequired = true, type = "String", remark = "用户名称")
	String userName;
	
	@APIField(isRequired = true, type = "String", remark = "密码")
	String password;
	
	@APIField(isRequired = false, type = "Long", remark = "当前时间的时间戳")
	Long currentTime;
}
