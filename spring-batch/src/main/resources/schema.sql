DROP TABLE IF EXISTS TBL_STOCKS;
 
CREATE TABLE TBL_STOCKS (
  ticker CHAR(5) PRIMARY KEY,
  bought_price	DECIMAL,
  shares DECIMAL,
  purchase_amt	DECIMAL,
  current_price	DECIMAL,
  gl_reported	DECIMAL,
  gl_calculated DECIMAL
  );
  

 

