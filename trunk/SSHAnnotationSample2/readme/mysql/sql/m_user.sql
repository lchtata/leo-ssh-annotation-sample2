/*----------------------------------------------------------------------------*/
/*【表名】        ユーザマスタ(m_user) */
/*【表説明】      ユーザ管理情報。ログインマスタのユーザＩＤと一対一の関係。 */
/*                 */
/*【発行日】      2013/07/01 */
/*【発行者】       */
/*【対象業務】     */
/*----------------------------------------------------------------------------*/
DROP TABLE IF EXISTS m_user;
CREATE TABLE m_user(
	user_id                       DECIMAL(18)    	COMMENT 'ユーザID',
	name                          VARCHAR(94)    	COMMENT '名前',
	login_id                      VARCHAR(50)    	COMMENT 'ログインID',
	password                      VARCHAR(100)   	COMMENT 'パスワード',
	login_date                    datetime       	COMMENT '最終ログイン日時',
	last_pwd_mod                  VARCHAR(8)     	COMMENT '最終パスワード変更日付',
	pwd_fail_cnt                  DECIMAL(2)     	DEFAULT 0	COMMENT '連続パスワード間違い回数',
	ins_date                      datetime       	COMMENT '登録日時',
	ins_user_id                   VARCHAR(20)    	COMMENT '登録ユーザー',
	upd_date                      datetime       	COMMENT '更新日時',
	upd_user_id                   VARCHAR(20)    	COMMENT '更新ユーザー',
	del_date                      datetime       	COMMENT '削除日時',
	del_user_id                   VARCHAR(20)    	COMMENT '削除ユーザー',
	del_flg                       VARCHAR(1)     	DEFAULT 0	COMMENT '削除フラグ',
	upd_cnt                       DECIMAL(18)    	DEFAULT 1	COMMENT '更新回数',
CONSTRAINT PK_m_user
	PRIMARY KEY  (user_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8
COMMENT 'ユーザマスタ 【2013/07/01】';
