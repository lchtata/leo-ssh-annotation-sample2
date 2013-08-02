/*----------------------------------------------------------------------------*/
/*【表名】        システム管理マスタ(m_system) */
/*【表説明】      システム管理マスタ */
/*                 */
/*【発行日】      2013/07/04 */
/*【発行者】       */
/*【対象業務】     */
/*----------------------------------------------------------------------------*/
DROP TABLE IF EXISTS m_system;
CREATE TABLE m_system(
	sys_key                       VARCHAR(100)   	COMMENT 'キー',
	sys_val                       VARCHAR(4000)  	COMMENT '値',
	description                   VARCHAR(256)   	COMMENT '説明',
	ins_date                      datetime       	COMMENT '登録日時',
	ins_user_id                   VARCHAR(20)    	COMMENT '登録ユーザー',
	upd_date                      datetime       	COMMENT '更新日時',
	upd_user_id                   VARCHAR(20)    	COMMENT '更新ユーザー',
	del_date                      datetime       	COMMENT '削除日時',
	del_user_id                   VARCHAR(20)    	COMMENT '削除ユーザー',
	del_flg                       VARCHAR(1)     	DEFAULT 0	COMMENT '削除フラグ',
	upd_cnt                       DECIMAL(18)    	DEFAULT 1	COMMENT '更新回数',
CONSTRAINT PK_m_system
	PRIMARY KEY  (sys_key)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8
COMMENT 'システム管理マスタ 【2013/07/04】';
