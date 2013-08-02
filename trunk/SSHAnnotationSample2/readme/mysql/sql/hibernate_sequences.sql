/*----------------------------------------------------------------------------*/
/*【表名】        ID自動生成用テーブル(hibernate_sequences) */
/*【表説明】      ID自動生成用テーブル。 */
/*                 */
/*【発行日】      2013/07/03 */
/*【発行者】       */
/*【対象業務】     */
/*----------------------------------------------------------------------------*/
DROP TABLE IF EXISTS hibernate_sequences;
CREATE TABLE hibernate_sequences(
	sequence_name                 VARCHAR(255)   	COMMENT 'シーケンス名',
	next_val                      DECIMAL(18)    	COMMENT '次のシーケンス値',
CONSTRAINT PK_hibernate_sequences
	PRIMARY KEY  (sequence_name)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8
COMMENT 'ID自動生成用テーブル 【2013/07/03】';
