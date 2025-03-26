package com.sist.vo;

import lombok.Data;

/*
NO                  NUMBER         
TITLE      NOT NULL VARCHAR2(4000) 
POSTER     NOT NULL VARCHAR2(260)  
CHEF       NOT NULL VARCHAR2(500)  
LINK                VARCHAR2(300)  
HIT                 NUMBER         
REPLYCOUNT          NUMBER         
LIKECOUNT           NUMBER          
 */
@Data
public class RecipeVO {
   private int no,hit,replycount,likecount;
   private String title,poster,chef,link;
}
