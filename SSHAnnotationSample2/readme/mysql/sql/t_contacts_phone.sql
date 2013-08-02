/*----------------------------------------------------------------------------*/
/*【表名】        連絡先電番マスタ(t_contacts_phone) */
/*【表説明】       */
/*                 */
/*【発行日】      2013/07/03 */
/*【発行者】       */
/*【対象業務】     */
/*----------------------------------------------------------------------------*/
DROP TABLE IF EXISTS t_contacts_phone;
CREATE TABLE t_contacts_phone(
	contacts_seq                  DECIMAL(18)    	NOT NULL	COMMENT '連絡先連番',
	phone_type                    VARCHAR(2)     	NOT NULL	COMMENT '電番分類',
	phone_label                   VARCHAR(20)    	COMMENT 'ユーザ定義タイプ',
	phone_number                  VARCHAR(11)    	COMMENT '電話番号',
	ins_date                      datetime       	COMMENT '登録日時',
	ins_user_id                   VARCHAR(20)    	COMMENT '登録ユーザーID',
	upd_date                      datetime       	COMMENT '更新日時',
	upd_user_id                   VARCHAR(20)    	COMMENT '更新ユーザーID',
	del_date                      datetime       	COMMENT '削除日時',
	del_user_id                   VARCHAR(20)    	COMMENT '削除ユーザーID',
	del_flg                       VARCHAR(1)     	DEFAULT 0	COMMENT '削除フラグ',
	upd_cnt                       int            	DEFAULT 1	COMMENT '更新回数',
CONSTRAINT PK_t_contacts_phone
	PRIMARY KEY  (contacts_seq, phone_type)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8
COMMENT '連絡先電番マスタ 【2013/07/03】';
