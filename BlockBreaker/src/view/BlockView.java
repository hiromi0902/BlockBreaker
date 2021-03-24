package view;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import controller.BlockControl;
import model.BlockBean;

public class BlockView extends Frame implements ActionListener , MouseMotionListener{

	//ブロック崩しの描画領域：BlockViewPanel
	BlockViewPanel BlockVP;
	//ブロック崩し制御用スレッド：BlockControl
	BlockControl BlockC ;
	//開始ボタン：Button
	Button startButton;
	//終了ボタン：Button
	Button endButton;
	//リプレイボタン：Button
	Button rePlayButton ;
	//画像情報クラス：BlockBean ※インスタンス生成が必要
	BlockBean imageInfo = new BlockBean();

	//画像情報クラスだけsetter,getter用意
	public BlockBean getImageInfo() {
		return imageInfo;
	}
	public void setImageInfo(BlockBean imageInfo) {
		this.imageInfo = imageInfo;
	}

	//コンストラクタ
	public BlockView() {
		//描写エリア,パネル設定
		BlockViewPanel BlockVP = new BlockViewPanel();
		BlockVP.setBackground(Color.black);
		BlockVP.setVisible(true);
		this.add(BlockVP);
		//ボタン設定
		Button startButton = new Button("開始");//開始ボタン
		Button endButton = new Button("終了");//終了ボタン
		Button rePlayButton = new Button("リプレイ");//リプレイボタン
		this.add(startButton);
		this.add(endButton);
		this.add(rePlayButton);
		//リスナーとして登録設定
		startButton.addActionListener(this);
		endButton.addActionListener(this);
		rePlayButton.addActionListener(this);
		//初期情報セット
		initialState();

	}
	//初期設定
	public void initialState() {
		//初期
		//画像情報セット
		imageInfo.setBallImage(Toolkit.getDefaultToolkit().getImage("src/ball.jpg"));
		imageInfo.setRacketImage(Toolkit.getDefaultToolkit().getImage("src/raket.jpg"));
		imageInfo.setBlockImage(Toolkit.getDefaultToolkit().getImage("src/block.jpg"));
		//ボールの初期位置
		imageInfo.setBallx(10);
		imageInfo.setBally(100);
		//ボールの縦、横
		imageInfo.setBallWidth(5);
		imageInfo.setBallHeight(5);
		//実行時間間隔
		imageInfo.setRewriteSpeed(5);
		//ボールの増分量
		imageInfo.setBallNextx(2);
		imageInfo.setBallNexty(2);
		//ブロックの横幅、縦幅、マージン
		imageInfo.setBlockWidth(50);
		imageInfo.setBlockHeight(20);
		imageInfo.setBlockMargin(10);
		//ブロックの行、列
		imageInfo.setBlockRow(3);
		imageInfo.setBlockColumn(5);
		//ブロックの初期状態
		imageInfo.blockInitialState();
		//ブロックの状態
		imageInfo.setBlockStatus(0);
		//0=初期状態,1=実行中,2=ボールが下に行った時,3=ボールが無くなった時
	}

	//表示情報設定
	public void setScreenInfo() {
		int buttonHeight = 30 ;	//ボタンの高さ

		//見える領域の（インセット）の情報を取得
		Insets insets =this.getInsets();
		int areaWidth = this.getWidth() - insets.left - insets.right ;
		int areaHeight =this.getHeight() - insets.top - insets.bottom - buttonHeight ;

		//インセットに合わせて描写エリアを配置
		BlockVP.setBound(insets.left,insets.top,areaWidth,areaHeight);

		//ボタンの幅
		int buttonWidth = areaWidth / 3 ;

		//ボタンの配置を計算
		int buttonx = insets.left ;//ボタンx軸基準値
		int buttony = this.getHeight() - insets.bottom - buttonHeight ;//ボタンy軸基準値

		//ボタンの配置
		startButton.setBounds(buttonx, buttony, buttonWidth, buttonHeight);
		endButton.setBounds(buttonx + buttonWidth , buttony , buttonWidth, buttonHeight);
		rePlayButton.setBounds(buttonx + buttonWidth + 2 , buttony , buttonWidth , buttonHeight);

		//ラケットの高さと幅をセット
		imageInfo.setRacketWidth(50);
		imageInfo.setRacketHeight(10);

		//ラケットの位置情報をリセット
		imageInfo.setRacketx(areaWidth - imageInfo.getRacketWidth()/2);
		imageInfo.setRackety(areaHeight - imageInfo.getRacketWidth());

		//描写領域の幅と高さの情報をセット
		imageInfo.setBlockImageWidth(BlockVP.getWidth());
		imageInfo.setBlockImageHeight(areaHeight);

	}
	//ブロックが無くなったらゲーム終了
	public void gameClear() {
		BlockC.interrupt();
	}

	//描写処理
	public void drawingProcess(BlockBean bb) {
	//画像情報を渡して書き換え指示
		BlockVP.imageRewrite(bb);

	}
	//開始ボタンが押された時
	public void startGame() {
		//1
		if(imageInfo.getBlockStatus()==0) {
			imageInfo.setBlockStatus(1);
			BlockC = new BlockControl(this);
			BlockC.start();
		}
	}

	//終了ボタンが押された時
	public void endGame() {
		System.exit(0);
	}

	//再開ボタンが押された時
	public void rePlayGame() {
		//2
		if(imageInfo.getBlockStatus()==2||imageInfo.getBlockStatus()==3) {
			initialState();
			startGame();
		}

	}
	//配置ボタンの実行処理
	public void buttonProcessing(ActionEvent AE) {
		//3
		if(AE.getSource().equals(startButton)) {
			startGame();
		}
		//4
		else if(AE.getSource().equals(endButton)) {
			endGame();
		}
		//5
		else if(AE.getSource().equals(rePlayButton)) {
			rePlayGame();
		}
	}
	//マウスがドラッグされた処理
	@Override
	public void mouseDragged(MouseEvent e) {
		// 空実装
	}


	//マウスが移動した処理
	public void mouseMotion(MouseEvent ME) {
		//マウスの位置保持
		int Mouse ;
		//6
		if(ME.getX()+imageInfo.getRacketWidth()>imageInfo.getBlockImageWidth()) {
			//領域に収まるように計算し、マウスの位置保持にセット
			Mouse = ME.getX();
			//ラケットの座標set
			imageInfo.setRackety(Mouse);
		}
		else{
			//マウス移動分をマウス位置保持にセット
			Mouse = imageInfo.getBlockImageWidth() - imageInfo.getRacketWidth();
			}

			//ラケットの座標セット
			imageInfo.setRackety(Mouse);
			//描写処理
			drawingProcess(imageInfo);

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}


}


