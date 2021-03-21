package model;

public class BlockModel {
	//判定
	public BlockBean blockJudge(BlockBean BBean) {

	//ボール中心のｘ座標（引数1より退避）：int
	int ballx = BBean.getBallx();
	//ボール中心のy座標（引数1より退避）：int
	int bally = BBean.getBally();
	//ボールの横幅（引数1より退避）：int
	int ballWidth = BBean.getBallWidth();
	//ボールの縦幅（引数1より退避）：int
	int ballHeight = BBean.getBallHeight();
	//ラケットの左上点のｘ座標（引数1より退避）：int
	int racketx = BBean.getRacketx();
	//ラケットの左上点のy座標（引数1より退避）：int
	int rackety = BBean.getRackety();
	//ラケットの横幅（引数1より退避）：int
	int racketWidth = BBean.getRacketWidth();
	//ラケットの縦幅（引数1より退避）：int
	int racketyHeight = BBean.getRacketHeight();
	//ブロック崩しの描画範囲の横幅（引数1より退避）：int
	int blockImageWidth = BBean.getBlockImageWidth();
	//ブロック崩しの描画範囲の縦幅（引数1より退避）：int
	int blockImageHeight = BBean.getBlockImageHeight();
	//次のボールのx座標増分量（引数1より退避）：int
	int ballNextx = BBean.getBallNextx();
	//次のボールのy座標増分量（引数1より退避）：int
	int ballNexty = BBean.getBallNexty();
	//配列のサイズ（引数1より退避）：int
	int blockStatus = BBean.getBlockRow()* BBean.getBlockColumn();


	//条①
	if (BBean.getBallx() + BBean.getBallHeight() >= BBean.getRackety()
				&& BBean.getBally() + BBean.getBallHeight() <= BBean.getRackety() + BBean.getRacketWidth()
				&& BBean.getBallx() + BBean.getBallWidth() >= BBean.getRacketx()
				&& BBean.getBallx() <= BBean.getRacketx() + BBean.getRacketWidth()){
			//上に返す
			ballNexty = -2 ;
		}
	//条②
		else if (BBean.getBallx() < BBean.getRacketx() || BBean.getBallx()
				+ BBean.getBallWidth() > BBean.getRacketx() + BBean.getRacketWidth()){
		}
	//条③
		else if (BBean.getBallNextx() == 0) {
			//ボールは垂直に返す
			ballNextx = 0 ;
		}
	//条④
		else if (BBean.getBallNextx() < BBean.getRacketx()) {
			//左斜め上に返す
			ballNextx = -2 ;
		}
	//条⑤
		else if (BBean.getBallx() + BBean.getBallWidth() > BBean.getRacketx() + BBean.getBallWidth()) {
			//右斜め上に返す
			ballNextx = 2 ;
		}
	//条⑥
		if(BBean.getBallx() < 0) {
			//
			ballNextx = 2 ;
		}
	//条⑦
		else if(BBean.getBallx() + BBean.getBallWidth() > BBean.getBlockImageWidth()) {
			//反転
			ballNextx = -2 ;
		}
	//条⑧
		else if(BBean.getBally() < 0) {
			//反転
			ballNextx = 2 ;

				//繰り返し①
				for(int counter = 0 ; counter < blockStatus ; counter++) {

				//条⑨
					if(BBean.getBlock()[counter] == 1) {
						BBean.setBlockStatus(2);
					}
					//条⑩
					else if(BBean.getBally() + BBean.getBallWidth() >= BBean.getBlocky()[counter]
							&& bally <= BBean.getBlocky()[counter] + BBean.getBlockHeight()
							&& ballx + ballWidth  >= BBean.getBlockx()[counter]
							&& ballx <= BBean.getBlockx()[counter] + BBean.getBlockWidth()) {

						ballNexty = - ballNexty ;
						//ブロックを消す
						BBean.setBlock(counter) ;
						BBean.setBlocks(-1) ;
					}
				}
					//条11
					if(bally + ballHeight > blockImageHeight + 100) {
						BBean.setBlockStatus(2);
					}
					ballx = ballx + ballx ;
					bally = bally + bally ;

					BBean.setBallx(ballx);
					BBean.setBally(bally);

					BBean.setBallNextx(ballNextx);
					BBean.setBallNexty(ballNexty);
				}
			}
	}



