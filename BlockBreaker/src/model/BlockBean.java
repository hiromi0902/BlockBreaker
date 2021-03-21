package model;
import java.awt.Image;

public class BlockBean {

	//クラス変数
	private Image racketImage;
	private Image blockImage;
	private Image ballImage;
	private int rewriteSpeed;//書き換え時間
	private int ballWidth; //ボール幅：横
	private int ballHeight; //ボール幅：縦
	private int ballx; //中心x座標
	private int bally;//中心y座標
	private int ballNextx; //次のボールの増分量
	private int ballNexty;
	private int blockImageWidth;//横
	private int blockImageHeight;//縦
	private int racketx;//ラケット左上点のx座標
	private int rackety;//ラケット左上点のy座標
	private int racketWidth;//ラケット横幅
	private int racketHeight;//ラケット縦幅
	private int block[];//ブロックがあるかどか
	private int blockx[];//ブロックの座標：横
	private int blocky[];//ブロックの座標：縦
	private int blockWidth;//ブロック幅：横
	private int blockHeight;//ブロック幅：縦
	private int blockMargin;//ブロックのマージン
	private int blockRow;//ブロックの行
	private int blockColumn;//ブロックの列
	private int blocks;//ブロックの個数
	private int blockStatus;//状態


	public Image getBallImage() {
		return ballImage;
	}

	public void setBallImage(Image ballImage) {
		this.ballImage = ballImage;
	}

	public Image getRacketImage() {
		return racketImage;
	}

	public void setRacketImage(Image racketImage) {
		this.racketImage = racketImage;
	}

	public Image getBlockImage() {
		return blockImage;
	}

	public void setBlockImage(Image blockImage) {
		this.blockImage = blockImage;
	}

	public int getRewriteSpeed() {
		return rewriteSpeed;
	}

	public void setRewriteSpeed(int rewriteSpeed) {
		this.rewriteSpeed = rewriteSpeed;
	}
	public int getBallWidth() {
		return ballWidth;
	}

	public void setBallWidth(int ballWidth) {
		this.ballWidth = ballWidth;
	}

	public int getBallHeight() {
		return ballHeight;
	}

	public void setBallHeight(int ballHeight) {
		this.ballHeight = ballHeight;
	}

	public int getBallx() {
		return ballx;
	}

	public void setBallx(int ballx) {
		this.ballx = ballx;
	}

	public int getBally() {
		return bally;
	}

	public void setBally(int bally) {
		this.bally = bally;
	}

	public int getBallNextx() {
		return ballNextx;
	}

	public void setBallNextx(int ballNextx) {
		this.ballNextx = ballNextx;
	}

	public int getBallNexty() {
		return ballNexty;
	}

	public void setBallNexty(int ballNexty) {
		this.ballNexty = ballNexty;
	}

	public int getBlockImageWidth() {
		return blockImageWidth;
	}

	public void setBlockImageWidth(int blockImageWidth) {
		this.blockImageWidth = blockImageWidth;
	}

	public int getBlockImageHeight() {
		return blockImageHeight;
	}

	public void setBlockImageHeight(int blockImageHeight) {
		this.blockImageHeight = blockImageHeight;
	}

	public int getRacketx() {
		return racketx;
	}

	public void setRacketx(int racketx) {
		this.racketx = racketx;
	}

	public int getRackety() {
		return rackety;
	}

	public void setRackety(int rackety) {
		this.rackety = rackety;
	}

	public int getRacketWidth() {
		return racketWidth;
	}

	public void setRacketWidth(int racketWidth) {
		this.racketWidth = racketWidth;
	}

	public int getRacketHeight() {
		return racketHeight;
	}

	public void setRacketHeight(int racketHeight) {
		this.racketHeight = racketHeight;
	}

	public int[] getBlock() {
		return block;
	}

	public void setBlock(int[] block) {
		this.block = block;
	}

	public int[] getBlockx() {
		return blockx;
	}

	public void setBlockx(int[] blockx) {
		this.blockx = blockx;
	}

	public int[] getBlocky() {
		return blocky;
	}

	public void setBlocky(int[] blocky) {
		this.blocky = blocky;
	}

	public int getBlockWidth() {
		return blockWidth;
	}

	public void setBlockWidth(int blockWidth) {
		this.blockWidth = blockWidth;
	}

	public int getBlockHeight() {
		return blockHeight;
	}

	public void setBlockHeight(int blockHeight) {
		this.blockHeight = blockHeight;
	}

	public int getBlockMargin() {
		return blockMargin;
	}

	public void setBlockMargin(int blockMargin) {
		this.blockMargin = blockMargin;
	}

	public int getBlockRow() {
		return blockRow;
	}

	public void setBlockRow(int blockRow) {
		this.blockRow = blockRow;
	}

	public int getBlockColumn() {
		return blockColumn;
	}

	public void setBlockColumn(int blockColumn) {
		this.blockColumn = blockColumn;
	}

	public int getBlocks() {
		return blocks;
	}

	public void setBlocks(int blocks) {
		this.blocks = blocks;
	}

	public int getBlockStatus() {
		return blockStatus;
	}

	public void setBlockStatus(int blockStatus) {
		this.blockStatus = blockStatus;
	}

		//ブロック初期状態セット
	public void blockInitialState() {

		block = new int [blockRow * blockColumn];//ブロックがあるかどうかの配列変数
		blockx = new int [blockRow * blockColumn];
		blocky = new int [blockRow * blockColumn];
		blocks = blockRow * blockColumn;
		int counter1 ; //カウンター１
		int counter2 ; ///カウンター2
		int blockNumber = 0; //ブロック番号
		int blockStep = 0 ; //段ごとのy座標

		//ループ1
		for(counter1 = 0 ; counter1 < blockRow ; counter1++) {
			blockStep = counter1*(blockHeight+3)+blockMargin;
		//ループ2
		for(counter2 = 0 ; counter2 < blockColumn ; counter2++) {
			blockx[blockNumber] = counter2*(blockWidth+30)+blockMargin;
			blocky[blockNumber] = blockStep ;
			block[blockNumber] = 1;
			blockNumber++;
		}
		}
	}


	}



