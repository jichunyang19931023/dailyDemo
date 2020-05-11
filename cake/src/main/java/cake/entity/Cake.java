package cake.entity;

import lombok.Data;

@Data
public class Cake {
	// 蛋糕名称
	String cakeName;
	
	Integer sugar;
	
	Integer eggs;
	
	Integer flour;
	
	// 添加剂（可可粉，抹茶粉，草莓粉）
	String supplement;
}
