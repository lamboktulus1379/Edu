package com.danmogot.edunsi;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.danmogot.edunsi.R;
import com.danmogot.edunsi.libs.SoundPlayer;

import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private Session session;


    private FrameLayout gameFrame;
    private int frameHeight, frameWidth, initialFrameWidth;
    private LinearLayout startLayout;

    private SoundPlayer soundPlayer;

    LinearLayout llOrganik, llAnorganik, llPlastikTwo, llLogam, llKaca, llPlastik, llKertasTumbuhan;
    ConstraintLayout clStatusGame;


    Button btnStartPause;
    Button btnExit;

    public CountDownTimer mCountDownTimer;

    public boolean mTimerRunning;

    private long mTimeLeftInMillis;

    TextView tvViewCountdown, tvUsername, tvLevel, tvMiss;

    ImageView ivOne, ivTwo, ivThree, ivFour, ivFive, ivSix, ivSeven, ivEight, ivNine;
    ImageView ivTen, ivEleven, ivTwelve, ivThirteen, ivFourteen, ivFifteen, ivSixteen, ivSeventeen, ivEighteen;
    ImageView ivNineteen, ivTwenty, ivTwentyOne, ivTwentyTwo, ivTwentyThree, ivTwentyFour, ivTwentyFive;

    ImageView ivOrganik, ivAnorganik, ivPlastikTwo, ivLogam, ivKaca, ivPlastik, ivKertasTumbuhan;

    int current_miss = 0;
    int current_scoress = 0;


    private float ivOneX, ivOneY;
    private float ivTwoX, ivTwoY;
    private float ivThreeX, ivThreeY;
    private float ivFourX, ivFourY;
    private float ivFiveX, ivFiveY;
    private float ivSixX, ivSixY;
    private float ivSevenX, ivSevenY;
    private float ivEightX, ivEightY;
    private float ivNineX, ivNineY;
    private float ivTenX, ivTenY;
    private float ivElevenX, ivElevenY;
    private float ivTwelveX, ivTwelveY;
    private float ivThirteenX, ivThirteenY;
    private float ivFourteenX, ivFourteenY;
    private float ivFifteenX, ivFifteenY;
    private float ivSixteenX, ivSixteenY;
    private float ivSeventeenX, ivSeventeenY;
    private float ivEighteenX, ivEighteenY;

    private float ivNineteenX, ivNineteenY;
    private float ivTwentyX, ivTwentyY;
    private float ivTwentyOneX, ivTwentyOneY;
    private float ivTwentyTwoX, ivTwentyTwoY;
    private float ivTwentyThreeX, ivTwentyThreeY;
    private float ivTwentyFourX, ivTwentyFourY;
    private float ivTwentyFiveX, ivTwentyFiveY;

    float ivOneXDefault;
    float ivTwoXDefault;
    float ivThreeXDefault;
    float ivFourXDefault;
    float ivFiveXDefault;

    float ivSixXDefault;
    float ivSevenXDefault;
    float ivEightXDefault;
    float ivNineXDefault;
    float ivTenXDefault;

    float ivElevenXDefault;
    float ivTwelveXDefault;
    float ivThirteenXDefault;
    float ivFourteenXDefault;
    float ivFifteenXDefault;

    float ivSixteenXDefault;
    float ivSeventeenXDefault;
    float ivEighteenXDefault;
    float ivNineteenXDefault;
    float ivTwentyXDefault;

    float ivTwentyOneXDefault;
    float ivTwentyTwoXDefault;
    float ivTwentyThreeXDefault;
    float ivTwentyFourXDefault;
    float ivTwentyFiveXDefault;

    float ivOneYDefault;
    float ivTwoYDefault;
    float ivThreeYDefault;
    float ivFourYDefault;
    float ivFiveYDefault;

    float ivSixYDefault;
    float ivSevenYDefault;
    float ivEightYDefault;
    float ivNineYDefault;
    float ivTenYDefault;

    float ivElevenYDefault;
    float ivTwelveYDefault;
    float ivThirteenYDefault;
    float ivFourteenYDefault;
    float ivFifteenYDefault;

    float ivSixteenYDefault;
    float ivSeventeenYDefault;
    float ivEighteenYDefault;
    float ivNineteenYDefault;
    float ivTwentyYDefault;

    float ivTwentyOneYDefault;
    float ivTwentyTwoYDefault;
    float ivTwentyThreeYDefault;
    float ivTwentyFourYDefault;
    float ivTwentyFiveYDefault;

    float startY;

    Resources res;

    private TextView scoreLabel, highScoreLabel;
    private int score, highScore;
    int level;
    int miss = 0;
    private int speed = 5;

    String idS, levelS, usernameS, scoreS;


    Random r;
    String[] img_rubbish = {};

    String current_rubbishOne, current_rubbishTwo, current_rubbishThree, current_rubbishFour, current_rubbishFive, current_rubbishSix, current_rubbishSeven, current_rubbishEight, current_rubbishNine;
    String current_rubbishTen, current_rubbishEleven, current_rubbishTwelve, current_rubbishThirteen, current_rubbishFourteen, current_rubbishFifteen, current_rubbishSixteen, current_rubbishSeventeen, current_rubbishEighteen;
    String current_rubbishNineteen, current_rubbishTwenty, current_rubbishTwentyOne, current_rubbishTwentyTwo, current_rubbishTwentyThree, current_rubbishTwentyFour, current_rubbishTwentyFive;
    String kindRubbishOne, kindRubbishTwo, kindRubbishThree, kindRubbishFour, kindRubbishFive, kindRubbishSix, kindRubbishSeven, kindRubbishEight, kindRubbishNine;
    String kindRubbishTen, kindRubbishEleven, kindRubbishTwelve, kindRubbishThirteen, kindRubbishFourteen, kindRubbishFifteen, kindRubbishSixteen, kindRubbishSeventeen, kindRubbishEighteen;
    String kindRubbishNineteen, kindRubbishTwenty, kindRubbishTwentyOne, kindRubbishTwentyTwo, kindRubbishTwentyThree, kindRubbishTwentyFour, kindRubbishTwentyFive;


    private static final String IMAGEVIEW_TAG_ONE = "ivOne";
    private static final String IMAGEVIEW_TAG_TWO = "ivTwo";
    private static final String IMAGEVIEW_TAG_THREE = "ivThree";
    private static final String IMAGEVIEW_TAG_FOUR = "ivFour";
    private static final String IMAGEVIEW_TAG_FIVE = "ivFive";
    private static final String IMAGEVIEW_TAG_SIX = "ivSix";
    private static final String IMAGEVIEW_TAG_SEVEN = "ivSeven";
    private static final String IMAGEVIEW_TAG_EIGHT = "ivEight";
    private static final String IMAGEVIEW_TAG_NINE = "ivNine";
    private static final String IMAGEVIEW_TAG_TEN = "ivTen";
    private static final String IMAGEVIEW_TAG_ELEVEN = "ivEleven";
    private static final String IMAGEVIEW_TAG_TWELVE = "ivTwelve";
    private static final String IMAGEVIEW_TAG_THIRTEEN = "ivThirteen";
    private static final String IMAGEVIEW_TAG_FOURTEEN = "ivFourteen";
    private static final String IMAGEVIEW_TAG_FIFTEEN = "ivFifteen";
    private static final String IMAGEVIEW_TAG_SIXTEEN = "ivSixteen";
    private static final String IMAGEVIEW_TAG_SEVENTEEN = "ivSeventeen";
    private static final String IMAGEVIEW_TAG_EIGHTEEN = "ivEighteen";
    private static final String IMAGEVIEW_TAG_NINETEEN = "ivNineteen";
    private static final String IMAGEVIEW_TAG_TWENTY = "ivTwenty";
    private static final String IMAGEVIEW_TAG_TWENTYONE = "ivTwentyOne";
    private static final String IMAGEVIEW_TAG_TWENTYTWO = "ivTwentyTwo";
    private static final String IMAGEVIEW_TAG_TWENTYTHREE = "ivTwentyThree";
    private static final String IMAGEVIEW_TAG_TWENTYFOUR = "ivTwentyFour";
    private static final String IMAGEVIEW_TAG_TWENTYFIVE = "ivTwentyFive";


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        session = new Session(this);
        level = getIntent().getIntExtra("level", 1);

        idS = session.getId();
        usernameS = session.getUsername();
        scoreS = session.getScore();
        levelS = session.getLevel();

        if (level != 3) {
            startY = 510.0f;

            ivOneXDefault = 0.0f;
            ivTwoXDefault = 150.0f;
            ivThreeXDefault = 300.0f;
            ivFourXDefault = 450.0f;
            ivFiveXDefault = 600.0f;

            ivSixXDefault = 0.0f;
            ivSevenXDefault = 150.0f;
            ivEightXDefault = 300.0f;
            ivNineXDefault = 450.0f;
            ivTenXDefault = 600.0f;

            ivElevenXDefault = 0.0f;
            ivTwelveXDefault = 150.0f;
            ivThirteenXDefault = 300.0f;
            ivFourteenXDefault = 450.0f;
            ivFifteenXDefault = 600.0f;

            ivSixteenXDefault = 0.0f;
            ivSeventeenXDefault = 150.0f;
            ivEighteenXDefault = 300.0f;
            ivNineteenXDefault = 450.0f;
            ivTwentyXDefault = 600.0f;

            ivTwentyOneXDefault = 0.0f;
            ivTwentyTwoXDefault = 150.0f;
            ivTwentyThreeXDefault = 300.0f;
            ivTwentyFourXDefault = 450.0f;
            ivTwentyFiveXDefault = 600.0f;

            ivOneYDefault = -0.0f;
            ivTwoYDefault = -10.0f;
            ivThreeYDefault = -20.0f;
            ivFourYDefault = -20.0f;
            ivFiveYDefault = -40.0f;

            ivSixYDefault = -100.0f;
            ivSevenYDefault = -110.0f;
            ivEightYDefault = -120.0f;
            ivNineYDefault = -130.0f;
            ivTenYDefault = -200.0f;

            ivElevenYDefault = -200.0f;
            ivTwelveYDefault = -210.0f;
            ivThirteenYDefault = -220.0f;
            ivFourteenYDefault = -230.0f;
            ivFifteenYDefault = -240.0f;

            ivSixteenYDefault = -300.0f;
            ivSeventeenYDefault = -310.0f;
            ivEighteenYDefault = -320.0f;
            ivNineteenYDefault = -330.0f;
            ivTwentyYDefault = -340.0f;

            ivTwentyOneYDefault = -400.0f;
            ivTwentyTwoYDefault = -410.0f;
            ivTwentyThreeYDefault = -420.0f;
            ivTwentyFourYDefault = -430.0f;
            ivTwentyFiveYDefault = -440.0f;
        } else {
            startY = 310.0f;

            ivOneYDefault = 0.0f;
            ivTwoYDefault = -10.0f;
            ivThreeYDefault = -20.0f;
            ivFourYDefault = -30.0f;
            ivFiveYDefault = -40.0f;
            ivSixYDefault = -50.0f;
            ivSevenYDefault = -60.0f;
            ivEightYDefault = -70.0f;

            ivNineYDefault = -100.0f;
            ivTenYDefault = -110.0f;
            ivElevenYDefault = -120.0f;
            ivTwelveYDefault = -130.0f;
            ivThirteenYDefault = -140.0f;
            ivFourteenYDefault = -150.0f;
            ivFifteenYDefault = -160.0f;
            ivSixteenYDefault = -170.0f;

            ivSeventeenYDefault = -200.0f;
            ivEighteenYDefault = -210.0f;
            ivNineteenYDefault = -220.0f;
            ivTwentyYDefault = -230.0f;
            ivTwentyOneYDefault = -240.0f;
            ivTwentyTwoYDefault = -250.0f;
            ivTwentyThreeYDefault = -260.0f;
            ivTwentyFourYDefault = -270.0f;

            ivOneXDefault = 0.0f;
            ivTwoXDefault = 100.0f;
            ivThreeXDefault = 200.0f;
            ivFourXDefault = 300.0f;
            ivFiveXDefault = 400.0f;
            ivSixXDefault = 500.0f;
            ivSevenXDefault = 600.0f;
            ivEightXDefault = 700.0f;

            ivNineXDefault = 0.0f;
            ivTenXDefault = 100.0f;
            ivElevenXDefault = 200.0f;
            ivTwelveXDefault = 300.0f;
            ivThirteenXDefault = 400.0f;
            ivFourteenXDefault = 500.0f;
            ivFifteenXDefault = 600.0f;
            ivSixteenXDefault = 700.0f;

            ivSeventeenXDefault = 0.0f;
            ivEighteenXDefault = 100.0f;
            ivNineteenXDefault = 200.0f;
            ivTwentyXDefault = 300.0f;
            ivTwentyOneXDefault = 400.0f;
            ivTwentyTwoXDefault = 500.0f;
            ivTwentyThreeXDefault = 600.0f;
            ivTwentyFourXDefault = 700.0f;
        }

        if (level == 3) {
            mTimeLeftInMillis = 180000;
            img_rubbish = new String[]{
                    "akart",
                    "botolk",
                    "botoll",
                    "botolp",
                    "botol2k",
                    "botol3k",
                    "ceretl",
                    "daun2t",
                    "daun1t",
                    "daunt",
                    "jerukt",
                    "kalengl",
                    "kayut",
                    "kertast",
                    "piring2k",
                    "piringk",
                    "pisangt",
                    "plastic1p",
                    "plasticp",
                    "rumput2t",
            };
        } else if (level == 2) {
            mTimeLeftInMillis = 300000;
            img_rubbish = new String[]{
                    "akarto",
                    "batu2ba",
                    "batu3ba",
                    "batuba",
                    "botolka",
                    "botolla",
                    "botolp",
                    "botol2ka",
                    "botol3ka",
                    "ceretla",
                    "daging2so",
                    "daging3so",
                    "daging4so",
                    "dagingso",
                    "daun2to",
                    "daun1to",
                    "daunto",
                    "jerukto",
                    "kalengla",
                    "kayuto",
                    "kertasto",
                    "piring2ka",
                    "piringka",
                    "pisangto",
                    "plastic1p",
                    "plasticp",
                    "rumput2to",
            };
        } else {
            mTimeLeftInMillis = 420000;
            img_rubbish = new String[]{
                    "akarto",
                    "batu2ba",
                    "batu3ba",
                    "batuba",
                    "botolka",
                    "botolla",
                    "botolpa",
                    "botol2ka",
                    "botol3ka",
                    "ceretla",
                    "daging2so",
                    "daging3so",
                    "daging4so",
                    "dagingso",
                    "daun2to",
                    "daun1to",
                    "daunto",
                    "jerukto",
                    "kalengla",
                    "kayuto",
                    "kertasto",
                    "piring2ka",
                    "piringka",
                    "pisangto",
                    "plastic1pa",
                    "plasticpa",
                    "rumput2to",
            };
        }

        current_rubbishOne = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishTwo = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishThree = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishFour = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishFive = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishSix = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishSeven = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishEight = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishNine = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishTen = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishEleven = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishTwelve = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishThirteen = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishFourteen = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishFifteen = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishSixteen = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishSeventeen = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishEighteen = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishNineteen = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishTwenty = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishTwentyOne = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishTwentyTwo = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishTwentyThree = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishTwentyFour = img_rubbish[r.nextInt(img_rubbish.length)];
        current_rubbishTwentyFive = img_rubbish[r.nextInt(img_rubbish.length)];

        kindRubbishOne = current_rubbishOne.substring(current_rubbishOne.length() - 1);
        kindRubbishTwo = current_rubbishTwo.substring(current_rubbishTwo.length() - 1);
        kindRubbishThree = current_rubbishThree.substring(current_rubbishThree.length() - 1);
        kindRubbishFour = current_rubbishFour.substring(current_rubbishFour.length() - 1);
        kindRubbishFive = current_rubbishFive.substring(current_rubbishFive.length() - 1);
        kindRubbishSix = current_rubbishSix.substring(current_rubbishSix.length() - 1);
        kindRubbishSeven = current_rubbishSeven.substring(current_rubbishSeven.length() - 1);
        kindRubbishEight = current_rubbishEight.substring(current_rubbishEight.length() - 1);
        kindRubbishNine = current_rubbishNine.substring(current_rubbishNine.length() - 1);
        kindRubbishTen = current_rubbishTen.substring(current_rubbishTen.length() - 1);
        kindRubbishEleven = current_rubbishEleven.substring(current_rubbishEleven.length() - 1);
        kindRubbishTwelve = current_rubbishTwelve.substring(current_rubbishTwelve.length() - 1);
        kindRubbishThirteen = current_rubbishThirteen.substring(current_rubbishThirteen.length() - 1);
        kindRubbishFourteen = current_rubbishFourteen.substring(current_rubbishFourteen.length() - 1);
        kindRubbishFifteen = current_rubbishFifteen.substring(current_rubbishFifteen.length() - 1);
        kindRubbishSixteen = current_rubbishSixteen.substring(current_rubbishSixteen.length() - 1);
        kindRubbishSeventeen = current_rubbishSeventeen.substring(current_rubbishSeventeen.length() - 1);
        kindRubbishEighteen = current_rubbishEighteen.substring(current_rubbishEighteen.length() - 1);
        kindRubbishNineteen = current_rubbishNineteen.substring(current_rubbishNineteen.length() - 1);
        kindRubbishTwenty = current_rubbishTwenty.substring(current_rubbishTwenty.length() - 1);
        kindRubbishTwentyOne = current_rubbishTwentyOne.substring(current_rubbishTwentyOne.length() - 1);
        kindRubbishTwentyTwo = current_rubbishTwentyTwo.substring(current_rubbishTwentyTwo.length() - 1);
        kindRubbishTwentyThree = current_rubbishTwentyThree.substring(current_rubbishTwentyThree.length() - 1);
        kindRubbishTwentyFour = current_rubbishTwentyFour.substring(current_rubbishTwentyFour.length() - 1);
        kindRubbishTwentyFive = current_rubbishTwentyFive.substring(current_rubbishTwentyFive.length() - 1);


        gameFrame = findViewById(R.id.gameFrame);
        startLayout = findViewById(R.id.startLayout);
        scoreLabel = findViewById(R.id.scoreLabel);
        highScoreLabel = findViewById(R.id.highScoreLabel);

        score = 0;
        highScore = Integer.valueOf(getIntent().getStringExtra("high_score"));

        // High Score
       // settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
       // highScore = settings.getInt("HIGH_SCORE", 0);
        highScoreLabel.setText("High Score : " + getIntent().getStringExtra("high_score"));

        ivOne.setTag(IMAGEVIEW_TAG_ONE);
        ivTwo.setTag(IMAGEVIEW_TAG_TWO);
        ivThree.setTag(IMAGEVIEW_TAG_THREE);
        ivFour.setTag(IMAGEVIEW_TAG_FOUR);
        ivFive.setTag(IMAGEVIEW_TAG_FIVE);
        ivSix.setTag(IMAGEVIEW_TAG_SIX);
        ivSeven.setTag(IMAGEVIEW_TAG_SEVEN);
        ivEight.setTag(IMAGEVIEW_TAG_EIGHT);
        ivNine.setTag(IMAGEVIEW_TAG_NINE);
        ivTen.setTag(IMAGEVIEW_TAG_TEN);
        ivEleven.setTag(IMAGEVIEW_TAG_ELEVEN);
        ivTwelve.setTag(IMAGEVIEW_TAG_TWELVE);
        ivThirteen.setTag(IMAGEVIEW_TAG_THIRTEEN);
        ivFourteen.setTag(IMAGEVIEW_TAG_FOURTEEN);
        ivFifteen.setTag(IMAGEVIEW_TAG_FIFTEEN);
        ivSixteen.setTag(IMAGEVIEW_TAG_SIXTEEN);
        ivSeventeen.setTag(IMAGEVIEW_TAG_SEVENTEEN);
        ivEighteen.setTag(IMAGEVIEW_TAG_EIGHTEEN);
        ivNineteen.setTag(IMAGEVIEW_TAG_NINETEEN);
        ivTwenty.setTag(IMAGEVIEW_TAG_TWENTY);
        ivTwentyOne.setTag(IMAGEVIEW_TAG_TWENTYONE);
        ivTwentyTwo.setTag(IMAGEVIEW_TAG_TWENTYTWO);
        ivTwentyThree.setTag(IMAGEVIEW_TAG_TWENTYTHREE);
        ivTwentyFour.setTag(IMAGEVIEW_TAG_TWENTYFOUR);
        ivTwentyFive.setTag(IMAGEVIEW_TAG_TWENTYFIVE);

        ivOne.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivOne);
                v.startDrag(dragData, shadow, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });

        ivTwo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivTwo);
                v.startDrag(dragData, shadow, v, 0);

                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });

        ivThree.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivThree);
                v.startDrag(dragData, shadow, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });

        ivFour.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivFour);
                v.startDrag(dragData, shadow, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });

        ivFive.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivFive);
                v.startDrag(dragData, shadow, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        ivSix.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivSix);
                v.startDrag(dragData, shadow, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        ivSeven.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivSeven);
                v.startDrag(dragData, shadow, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        ivEight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivEight);
                v.startDrag(dragData, shadow, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        ivNine.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivNine);
                v.startDrag(dragData, shadow, v, 0);
                v.setVisibility(View.INVISIBLE);

                return true;
            }
        });
        ivTen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivTen);
                v.startDrag(dragData, shadow, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        ivEleven.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivEleven);
                v.startDrag(dragData, shadow, v, 0);

                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        ivTwelve.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivTwelve);
                v.startDrag(dragData, shadow, v, 0);

                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        ivThirteen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivThirteen);
                v.startDrag(dragData, shadow, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        ivFourteen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivFourteen);
                v.startDrag(dragData, shadow, v, 0);

                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        ivFifteen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivFifteen);
                v.startDrag(dragData, shadow, v, 0);

                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        ivSixteen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivSixteen);
                v.startDrag(dragData, shadow, v, 0);
                v.setVisibility(View.INVISIBLE);

                return true;
            }
        });
        ivSeventeen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivSeventeen);
                v.startDrag(dragData, shadow, v, 0);
                v.setVisibility(View.INVISIBLE);

                return true;
            }
        });
        ivEighteen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivEighteen);
                v.startDrag(dragData, shadow, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });

        ivNineteen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivNineteen);
                v.startDrag(dragData, shadow, v, 0);

                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        ivTwenty.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivTwenty);
                v.startDrag(dragData, shadow, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        ivTwentyOne.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivTwentyOne);
                v.startDrag(dragData, shadow, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        ivTwentyTwo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivTwentyTwo);
                v.startDrag(dragData, shadow, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        ivTwentyThree.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivTwentyThree);
                v.startDrag(dragData, shadow, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        ivTwentyFour.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivTwentyFour);
                v.startDrag(dragData, shadow, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        ivTwentyFive.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) v.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                        item);

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(ivTwentyFive);
                v.startDrag(dragData, shadow, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });

        ivOrganik();
        ivAnorganik();
        ivPlastikTwo();
        ivLogam();
        ivKaca();
        ivPlastik();
        ivKertasTumbuhan();

        updateCountDownText();

        btnStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            mTimeLeftInMillis = millisUntilFinished;

                            updateCountDownText();

                            if (level == 1) {
                                ivOne();
                                ivTwo();
                                ivThree();
                                ivFour();
                                ivFive();
                                ivSix();
                                ivSeven();
                                ivEight();
                                ivNine();
                                ivTen();
                                ivEleven();
                                ivTwelve();
                                ivThirteen();
                                ivFourteen();
                                ivFifteen();
                                ivSixteen();
                                ivSeventeen();
                                ivEighteen();
                                ivNineteen();
                                ivTwenty();
                                ivTwentyOne();
                                ivTwentyTwo();
                                ivTwentyThree();
                                ivTwentyFour();
                                ivTwentyFive();


                            } else if (level == 2) {
                                ivOne();
                                ivTwo();
                                ivThree();
                                ivFour();
                                ivFive();
                                ivSix();
                                ivSeven();
                                ivEight();
                                ivNine();
                                ivTen();
                                ivEleven();
                                ivTwelve();
                                ivThirteen();
                                ivFourteen();
                                ivFifteen();
                                ivSixteen();
                                ivSeventeen();
                                ivEighteen();
                                ivNineteen();
                                ivTwenty();
                                ivTwentyOne();
                                ivTwentyTwo();
                                ivTwentyThree();
                                ivTwentyFour();
                                ivTwentyFive();


                            } else if (level == 3) {
                                ivOne();
                                ivTwo();
                                ivThree();
                                ivFour();
                                ivFive();
                                ivSix();
                                ivSeven();
                                ivEight();
                                ivNine();
                                ivTen();
                                ivEleven();
                                ivTwelve();
                                ivThirteen();
                                ivFourteen();
                                ivFifteen();
                                ivSixteen();
                                ivSeventeen();
                                ivEighteen();
                                ivNineteen();
                                ivTwenty();
                                ivTwentyOne();
                                ivTwentyTwo();
                                ivTwentyThree();
                                ivTwentyFour();
                                ivTwentyFive();

                            }
                            if (miss > current_miss) {
                                soundPlayer.playHitBlackSound();
                                current_miss = miss;
                            }
                            if (score > current_scoress) {
                                soundPlayer.playHitOrangeSound();
                                current_scoress = score;
                            }

                            if (miss == 3) {
                                int color = R.color.colorForegroundHigh;
                                gameFrame.setForeground(new ColorDrawable(ContextCompat.getColor(getBaseContext(), color)));
                            } else if (miss == 7) {
                                if (score > highScore) {
                                    highScore = score;
                                }
                                Toast.makeText(MainActivity.this, "Level belum berhasil, Coba lagi!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, WinLose.class);
                                intent.putExtra("message", "Level belum berhasil, Coba lagi!");
                                intent.putExtra("time", 1);
                                intent.putExtra("level", level);
                                intent.putExtra("score", highScore);
                                startActivity(intent);
                            }

                            if (score < 0) {
                                mCountDownTimer.cancel();
                                Toast.makeText(MainActivity.this, "Level belum berhasil, Coba lagi!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, WinLose.class);
                                intent.putExtra("message", "Level belum berhasil, Coba lagi!");
                                intent.putExtra("time", 1);
                                intent.putExtra("level", level);
                                intent.putExtra("score", highScore);
                                startActivity(intent);
                            }

                            if (score >= 1000 && level == 3) {
                                mCountDownTimer.cancel();
                                if (score > highScore) {
                                    highScore = score;
                                }
                                Toast.makeText(MainActivity.this, "Level 3 berhasil!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, WinLose.class);
                                intent.putExtra("message", "Level 3 berhasil!");
                                intent.putExtra("time", mTimeLeftInMillis);
                                intent.putExtra("level", 3);
                                intent.putExtra("score", highScore);
                                startActivity(intent);
                            } else if (score >= 700 && level == 2) {
                                mCountDownTimer.cancel();
                                if (score > highScore) {
                                    highScore = score;
                                }
                                Toast.makeText(MainActivity.this, "Level 2 berhasil!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, WinLose.class);
                                intent.putExtra("message", "Level 2 berhasil!");
                                intent.putExtra("time", mTimeLeftInMillis);
                                intent.putExtra("level", 2);
                                intent.putExtra("score", highScore);
                                startActivity(intent);
                            } else if (score >= 500 && level == 1) {
                                mCountDownTimer.cancel();
                                Toast.makeText(MainActivity.this, "Level 1 berhasil!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, WinLose.class);
                                intent.putExtra("message", "Level 1 berhasil!");
                                intent.putExtra("time", mTimeLeftInMillis);
                                intent.putExtra("level", 1);
                                intent.putExtra("score", score);
                                startActivity(intent);
                            }

                            scoreLabel.setText("Score : " + score);
                            tvUsername.setText(usernameS);
                            tvLevel.setText("Level : " + level);
                            tvMiss.setText("Miss : " + miss);
                        }

                        @Override
                        public void onFinish() {
                            mTimerRunning = false;
                            mCountDownTimer.cancel();
                            Toast.makeText(MainActivity.this, "Waktu telah Habis!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, WinLose.class);
                            intent.putExtra("message", "Waktu telah habis!");
                            intent.putExtra("time", mTimeLeftInMillis);
                            intent.putExtra("level", 1);
                            intent.putExtra("score", score);
                            startActivity(intent);
                        }
                    }.start();

                    mTimerRunning = true;
                    if (Build.VERSION.SDK_INT >= 16) {
                        btnStartPause.setBackground(getResources().getDrawable(R.drawable.ic_pause_circle_filled_red_24dp));
                    } else {
                        btnStartPause.setText("Pause");
                    }
                }
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCountDownTimer.cancel();
                if (score > highScore) {
                    highScore = score;
                }
                Toast.makeText(MainActivity.this, "Anda telah keluar!! score: " + score, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, WinLose.class);
                intent.putExtra("message", "Anda telah keluar!");
                intent.putExtra("time", 1L);
                intent.putExtra("level", level);
                intent.putExtra("score", highScore);
                startActivity(intent);
            }
        });
    }


    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;

        if (Build.VERSION.SDK_INT >= 16) {
            btnStartPause.setBackground(getResources().getDrawable(R.drawable.ic_play_circle_filled_white_24dp));
        } else {
            btnStartPause.setText("Resume");
        }
    }

    public void ivLogam() {
        ivPlastikTwo.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();

                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        return true;
                    case DragEvent.ACTION_DRAG_EXITED:
                        return true;
                    case DragEvent.ACTION_DRAG_ENTERED:

                        return true;
                    case DragEvent.ACTION_DROP:
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        String dragData = (String) item.getText();
                        if (dragData.equals("ivOne")) {
                            if (kindRubbishOne.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishOne = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishOne = current_rubbishOne.substring(current_rubbishOne.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishOne, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivOneX = ivOneXDefault;
                            ivOneY = ivOne.getY() - startY;
                            ivOne.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwo")) {

                            if (kindRubbishTwo.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwo = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwo = current_rubbishTwo.substring(current_rubbishTwo.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwo, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwoX = ivTwoXDefault;
                            ivTwoY = ivTwo.getY() - startY;
                            ivTwo.setImageDrawable(drawable);
                        } else if (dragData.equals("ivThree")) {

                            if (kindRubbishThree.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishThree = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishThree = current_rubbishThree.substring(current_rubbishThree.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishThree, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivThreeX = ivThreeXDefault;
                            ivThreeY = ivThree.getY() - startY;
                            ivThree.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFour")) {

                            if (kindRubbishFour.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFour = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFour = current_rubbishFour.substring(current_rubbishFour.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFour, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFourX = ivFourXDefault;
                            ivFourY = ivFour.getY() - startY;
                            ivFour.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFive")) {

                            if (kindRubbishFive.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFive = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFive = current_rubbishFive.substring(current_rubbishFive.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFive, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFiveX = ivFiveXDefault;
                            ivFiveY = ivFive.getY() - startY;
                            ivFive.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSix")) {
                            if (kindRubbishSix.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSix = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSix = current_rubbishSix.substring(current_rubbishSix.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSix, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSixX = ivSixXDefault;
                            ivSixY = ivSix.getY() - startY;
                            ivSix.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSeven")) {
                            if (kindRubbishSeven.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSeven = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSeven = current_rubbishSeven.substring(current_rubbishSeven.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSeven, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSevenX = ivSevenXDefault;
                            ivSevenY = ivSeven.getY() - startY;
                            ivSeven.setImageDrawable(drawable);
                        } else if (dragData.equals("ivEight")) {
                            if (kindRubbishEight.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEight = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEight = current_rubbishEight.substring(current_rubbishEight.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEight, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivEightX = ivEightXDefault;
                            ivEightY = ivEight.getY() - startY;
                            ivEight.setImageDrawable(drawable);
                        } else if (dragData.equals("ivNine")) {
                            if (kindRubbishNine.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishNine = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishNine = current_rubbishNine.substring(current_rubbishNine.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishNine, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivNineX = ivNineXDefault;
                            ivNineY = ivNine.getY() - startY;
                            ivNine.setImageDrawable(drawable);

                        } else if (dragData.equals("ivTen")) {
                            if (kindRubbishTen.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTen = current_rubbishTen.substring(current_rubbishTen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTenX = ivTenXDefault;
                            ivTenY = ivTen.getY() - startY;
                            ivTen.setImageDrawable(drawable);

                        } else if (dragData.equals("ivEleven")) {
                            if (kindRubbishEleven.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEleven = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEleven = current_rubbishEleven.substring(current_rubbishEleven.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEleven, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivElevenX = ivElevenXDefault;
                            ivElevenY = ivEleven.getY() - startY;
                            ivEleven.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwelve")) {

                            if (kindRubbishTwelve.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwelve = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwelve = current_rubbishTwelve.substring(current_rubbishTwelve.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwelve, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwelveX = ivTwelveXDefault;
                            ivTwelveY = ivTwelve.getY() - startY;
                            ivTwelve.setImageDrawable(drawable);
                        } else if (dragData.equals("ivThirteen")) {
                            if (kindRubbishThirteen.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishThirteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishThirteen = current_rubbishThirteen.substring(current_rubbishThirteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishThirteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivThirteenX = ivThirteenXDefault;
                            ivThirteenY = ivThirteen.getY() - startY;
                            ivThirteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFourteen")) {
                            if (kindRubbishFourteen.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFourteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFourteen = current_rubbishFourteen.substring(current_rubbishFourteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFourteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFourteenX = ivFourteenXDefault;
                            ivFourteenY = ivFourteen.getY() - startY;
                            ivFourteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFifteen")) {
                            if (kindRubbishFifteen.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFifteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFifteen = current_rubbishFifteen.substring(current_rubbishFifteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFifteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFifteenX = ivFifteenXDefault;
                            ivFifteenY = ivFifteen.getY() - startY;
                            ivFifteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSixteen")) {
                            if (kindRubbishSixteen.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSixteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSixteen = current_rubbishSixteen.substring(current_rubbishSixteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSixteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSixteenX = ivSixteenXDefault;
                            ivSixteenY = ivSixteen.getY() - startY;
                            ivSixteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSeventeen")) {
                            if (kindRubbishSeventeen.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSeventeen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSeventeen = current_rubbishSeventeen.substring(current_rubbishSeventeen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSeventeen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSeventeenX = ivSeventeenXDefault;
                            ivSeventeenY = ivSeventeen.getY() - startY;
                            ivSeventeen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivEighteen")) {
                            if (kindRubbishEighteen.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEighteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEighteen = current_rubbishEighteen.substring(current_rubbishEighteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEighteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivEighteenX = ivEighteenXDefault;
                            ivEighteenY = ivEighteen.getY() - startY;
                            ivEighteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivNineteen")) {
                            if (kindRubbishNineteen.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishNineteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishNineteen = current_rubbishNineteen.substring(current_rubbishNineteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishNineteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivNineteenX = ivNineteenXDefault;
                            ivNineteenY = ivNineteen.getY() - startY;
                            ivNineteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwenty")) {
                            if (kindRubbishTwenty.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwenty = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwenty = current_rubbishTwenty.substring(current_rubbishTwenty.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwenty, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyX = ivTwentyXDefault;
                            ivTwentyY = ivTwenty.getY() - startY;
                            ivTwenty.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyOne")) {
                            if (kindRubbishTwentyOne.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyOne = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyOne = current_rubbishTwentyOne.substring(current_rubbishTwentyOne.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyOne, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyOneX = ivTwentyOneXDefault;
                            ivTwentyOneY = ivTwentyOne.getY() - startY;
                            ivTwentyOne.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyTwo")) {
                            if (kindRubbishTwentyTwo.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyTwo = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyTwo = current_rubbishTwentyTwo.substring(current_rubbishTwentyTwo.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyTwo, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyTwoX = ivTwentyTwoXDefault;
                            ivTwentyTwoY = ivTwentyTwo.getY() - startY;
                            ivTwentyTwo.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyThree")) {
                            if (kindRubbishTwentyThree.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyThree = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyThree = current_rubbishTwentyThree.substring(current_rubbishTwentyThree.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyThree, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyThreeX = ivTwentyThreeXDefault;
                            ivTwentyThreeY = ivTwentyThree.getY() - startY;
                            ivTwentyThree.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyFour")) {
                            if (kindRubbishTwentyFour.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyFour = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyFour = current_rubbishTwentyFour.substring(current_rubbishTwentyFour.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyFour, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyFourX = ivTwentyFourXDefault;
                            ivTwentyFourY = ivTwentyFour.getY() - startY;
                            ivTwentyFour.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyFive")) {
                            if (kindRubbishTwentyFive.equals("l")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyFive = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyFive = current_rubbishTwentyFive.substring(current_rubbishTwentyFive.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyFive, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyFiveX = ivTwentyFiveXDefault;
                            ivTwentyFiveY = ivTwentyFive.getY() - startY;
                            ivTwentyFive.setImageDrawable(drawable);
                        }
                        v.invalidate();
                        return true;

                    case DragEvent.ACTION_DRAG_ENDED:
                        setVisibility();
                        return true;

                    default:
                        break;
                }

                return true;
            }
        });
    }

    public void ivKaca() {
        ivKaca.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();

                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        return true;
                    case DragEvent.ACTION_DRAG_EXITED:
                        return true;
                    case DragEvent.ACTION_DRAG_ENTERED:

                        return true;
                    case DragEvent.ACTION_DROP:
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        String dragData = (String) item.getText();
                        if (dragData.equals("ivOne")) {
                            if (kindRubbishOne.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishOne = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishOne = current_rubbishOne.substring(current_rubbishOne.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishOne, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivOneX = ivOneXDefault;
                            ivOneY = ivOne.getY() - startY;
                            ivOne.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwo")) {

                            if (kindRubbishTwo.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwo = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwo = current_rubbishTwo.substring(current_rubbishTwo.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwo, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwoX = ivTwoXDefault;
                            ivTwoY = ivTwo.getY() - startY;
                            ivTwo.setImageDrawable(drawable);
                        } else if (dragData.equals("ivThree")) {

                            if (kindRubbishThree.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishThree = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishThree = current_rubbishThree.substring(current_rubbishThree.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishThree, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivThreeX = ivThreeXDefault;
                            ivThreeY = ivThree.getY() - startY;
                            ivThree.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFour")) {

                            if (kindRubbishFour.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFour = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFour = current_rubbishFour.substring(current_rubbishFour.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFour, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFourX = ivFourXDefault;
                            ivFourY = ivFour.getY() - startY;
                            ivFour.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFive")) {

                            if (kindRubbishFive.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFive = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFive = current_rubbishFive.substring(current_rubbishFive.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFive, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFiveX = ivFiveXDefault;
                            ivFiveY = ivFive.getY() - startY;
                            ivFive.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSix")) {
                            if (kindRubbishSix.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSix = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSix = current_rubbishSix.substring(current_rubbishSix.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSix, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSixX = ivSixXDefault;
                            ivSixY = ivSix.getY() - startY;
                            ivSix.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSeven")) {
                            if (kindRubbishSeven.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSeven = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSeven = current_rubbishSeven.substring(current_rubbishSeven.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSeven, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSevenX = ivSevenXDefault;
                            ivSevenY = ivSeven.getY() - startY;
                            ivSeven.setImageDrawable(drawable);
                        } else if (dragData.equals("ivEight")) {
                            if (kindRubbishEight.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEight = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEight = current_rubbishEight.substring(current_rubbishEight.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEight, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivEightX = ivEightXDefault;
                            ivEightY = ivEight.getY() - startY;
                            ivEight.setImageDrawable(drawable);
                        } else if (dragData.equals("ivNine")) {
                            if (kindRubbishNine.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishNine = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishNine = current_rubbishNine.substring(current_rubbishNine.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishNine, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivNineX = ivNineXDefault;
                            ivNineY = ivNine.getY() - startY;
                            ivNine.setImageDrawable(drawable);

                        } else if (dragData.equals("ivTen")) {
                            if (kindRubbishTen.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTen = current_rubbishTen.substring(current_rubbishTen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTenX = ivTenXDefault;
                            ivTenY = ivTen.getY() - startY;
                            ivTen.setImageDrawable(drawable);

                        } else if (dragData.equals("ivEleven")) {
                            if (kindRubbishEleven.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEleven = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEleven = current_rubbishEleven.substring(current_rubbishEleven.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEleven, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivElevenX = ivElevenXDefault;
                            ivElevenY = ivEleven.getY() - startY;
                            ivEleven.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwelve")) {

                            if (kindRubbishTwelve.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwelve = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwelve = current_rubbishTwelve.substring(current_rubbishTwelve.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwelve, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwelveX = ivTwelveXDefault;
                            ivTwelveY = ivTwelve.getY() - startY;
                            ivTwelve.setImageDrawable(drawable);
                        } else if (dragData.equals("ivThirteen")) {
                            if (kindRubbishThirteen.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishThirteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishThirteen = current_rubbishThirteen.substring(current_rubbishThirteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishThirteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivThirteenX = ivThirteenXDefault;
                            ivThirteenY = ivThirteen.getY() - startY;
                            ivThirteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFourteen")) {
                            if (kindRubbishFourteen.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFourteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFourteen = current_rubbishFourteen.substring(current_rubbishFourteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFourteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFourteenX = ivFourteenXDefault;
                            ivFourteenY = ivFourteen.getY() - startY;
                            ivFourteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFifteen")) {
                            if (kindRubbishFifteen.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFifteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFifteen = current_rubbishFifteen.substring(current_rubbishFifteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFifteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFifteenX = ivFifteenXDefault;
                            ivFifteenY = ivFifteen.getY() - startY;
                            ivFifteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSixteen")) {
                            if (kindRubbishSixteen.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSixteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSixteen = current_rubbishSixteen.substring(current_rubbishSixteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSixteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSixteenX = ivSixteenXDefault;
                            ivSixteenY = ivSixteen.getY() - startY;
                            ivSixteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSeventeen")) {
                            if (kindRubbishSeventeen.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSeventeen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSeventeen = current_rubbishSeventeen.substring(current_rubbishSeventeen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSeventeen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSeventeenX = ivSeventeenXDefault;
                            ivSeventeenY = ivSeventeen.getY() - startY;
                            ivSeventeen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivEighteen")) {
                            if (kindRubbishEighteen.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEighteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEighteen = current_rubbishEighteen.substring(current_rubbishEighteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEighteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivEighteenX = ivEighteenXDefault;
                            ivEighteenY = ivEighteen.getY() - startY;
                            ivEighteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivNineteen")) {
                            if (kindRubbishNineteen.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishNineteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishNineteen = current_rubbishNineteen.substring(current_rubbishNineteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishNineteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivNineteenX = ivNineteenXDefault;
                            ivNineteenY = ivNineteen.getY() - startY;
                            ivNineteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwenty")) {
                            if (kindRubbishTwenty.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwenty = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwenty = current_rubbishTwenty.substring(current_rubbishTwenty.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwenty, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyX = ivTwentyXDefault;
                            ivTwentyY = ivTwenty.getY() - startY;
                            ivTwenty.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyOne")) {
                            if (kindRubbishTwentyOne.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyOne = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyOne = current_rubbishTwentyOne.substring(current_rubbishTwentyOne.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyOne, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyOneX = ivTwentyOneXDefault;
                            ivTwentyOneY = ivTwentyOne.getY() - startY;
                            ivTwentyOne.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyTwo")) {
                            if (kindRubbishTwentyTwo.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyTwo = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyTwo = current_rubbishTwentyTwo.substring(current_rubbishTwentyTwo.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyTwo, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyTwoX = ivTwentyTwoXDefault;
                            ivTwentyTwoY = ivTwentyTwo.getY() - startY;
                            ivTwentyTwo.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyThree")) {
                            if (kindRubbishTwentyThree.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyThree = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyThree = current_rubbishTwentyThree.substring(current_rubbishTwentyThree.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyThree, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyThreeX = ivTwentyThreeXDefault;
                            ivTwentyThreeY = ivTwentyThree.getY() - startY;
                            ivTwentyThree.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyFour")) {
                            if (kindRubbishTwentyFour.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyFour = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyFour = current_rubbishTwentyFour.substring(current_rubbishTwentyFour.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyFour, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyFourX = ivTwentyFourXDefault;
                            ivTwentyFourY = ivTwentyFour.getY() - startY;
                            ivTwentyFour.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyFive")) {
                            if (kindRubbishTwentyFive.equals("k")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyFive = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyFive = current_rubbishTwentyFive.substring(current_rubbishTwentyFive.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyFive, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyFiveX = ivTwentyFiveXDefault;
                            ivTwentyFiveY = ivTwentyFive.getY() - startY;
                            ivTwentyFive.setImageDrawable(drawable);
                        }
                        v.invalidate();
                        return true;

                    case DragEvent.ACTION_DRAG_ENDED:
                        setVisibility();
                        return true;

                    default:
                        break;
                }

                return true;
            }
        });
    }

    public void ivPlastik() {
        ivPlastik.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();

                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        return true;
                    case DragEvent.ACTION_DRAG_EXITED:
                        return true;
                    case DragEvent.ACTION_DRAG_ENTERED:

                        return true;
                    case DragEvent.ACTION_DROP:
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        String dragData = (String) item.getText();
                        if (dragData.equals("ivOne")) {
                            if (kindRubbishOne.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishOne = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishOne = current_rubbishOne.substring(current_rubbishOne.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishOne, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivOneX = ivOneXDefault;
                            ivOneY = ivOne.getY() - startY;
                            ivOne.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwo")) {

                            if (kindRubbishTwo.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwo = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwo = current_rubbishTwo.substring(current_rubbishTwo.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwo, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwoX = ivTwoXDefault;
                            ivTwoY = ivTwo.getY() - startY;
                            ivTwo.setImageDrawable(drawable);
                        } else if (dragData.equals("ivThree")) {

                            if (kindRubbishThree.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishThree = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishThree = current_rubbishThree.substring(current_rubbishThree.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishThree, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivThreeX = ivThreeXDefault;
                            ivThreeY = ivThree.getY() - startY;
                            ivThree.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFour")) {

                            if (kindRubbishFour.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFour = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFour = current_rubbishFour.substring(current_rubbishFour.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFour, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFourX = ivFourXDefault;
                            ivFourY = ivFour.getY() - startY;
                            ivFour.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFive")) {

                            if (kindRubbishFive.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFive = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFive = current_rubbishFive.substring(current_rubbishFive.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFive, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFiveX = ivFiveXDefault;
                            ivFiveY = ivFive.getY() - startY;
                            ivFive.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSix")) {
                            if (kindRubbishSix.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSix = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSix = current_rubbishSix.substring(current_rubbishSix.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSix, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSixX = ivSixXDefault;
                            ivSixY = ivSix.getY() - startY;
                            ivSix.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSeven")) {
                            if (kindRubbishSeven.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSeven = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSeven = current_rubbishSeven.substring(current_rubbishSeven.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSeven, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSevenX = ivSevenXDefault;
                            ivSevenY = ivSeven.getY() - startY;
                            ivSeven.setImageDrawable(drawable);
                        } else if (dragData.equals("ivEight")) {
                            if (kindRubbishEight.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEight = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEight = current_rubbishEight.substring(current_rubbishEight.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEight, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivEightX = ivEightXDefault;
                            ivEightY = ivEight.getY() - startY;
                            ivEight.setImageDrawable(drawable);
                        } else if (dragData.equals("ivNine")) {
                            if (kindRubbishNine.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishNine = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishNine = current_rubbishNine.substring(current_rubbishNine.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishNine, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivNineX = ivNineXDefault;
                            ivNineY = ivNine.getY() - startY;
                            ivNine.setImageDrawable(drawable);

                        } else if (dragData.equals("ivTen")) {
                            if (kindRubbishTen.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTen = current_rubbishTen.substring(current_rubbishTen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTenX = ivTenXDefault;
                            ivTenY = ivTen.getY() - startY;
                            ivTen.setImageDrawable(drawable);

                        } else if (dragData.equals("ivEleven")) {
                            if (kindRubbishEleven.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEleven = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEleven = current_rubbishEleven.substring(current_rubbishEleven.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEleven, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivElevenX = ivElevenXDefault;
                            ivElevenY = ivEleven.getY() - startY;
                            ivEleven.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwelve")) {

                            if (kindRubbishTwelve.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwelve = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwelve = current_rubbishTwelve.substring(current_rubbishTwelve.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwelve, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwelveX = ivTwelveXDefault;
                            ivTwelveY = ivTwelve.getY() - startY;
                            ivTwelve.setImageDrawable(drawable);
                        } else if (dragData.equals("ivThirteen")) {
                            if (kindRubbishThirteen.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishThirteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishThirteen = current_rubbishThirteen.substring(current_rubbishThirteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishThirteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivThirteenX = ivThirteenXDefault;
                            ivThirteenY = ivThirteen.getY() - startY;
                            ivThirteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFourteen")) {
                            if (kindRubbishFourteen.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFourteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFourteen = current_rubbishFourteen.substring(current_rubbishFourteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFourteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFourteenX = ivFourteenXDefault;
                            ivFourteenY = ivFourteen.getY() - startY;
                            ivFourteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFifteen")) {
                            if (kindRubbishFifteen.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFifteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFifteen = current_rubbishFifteen.substring(current_rubbishFifteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFifteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFifteenX = ivFifteenXDefault;
                            ivFifteenY = ivFifteen.getY() - startY;
                            ivFifteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSixteen")) {
                            if (kindRubbishSixteen.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSixteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSixteen = current_rubbishSixteen.substring(current_rubbishSixteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSixteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSixteenX = ivSixteenXDefault;
                            ivSixteenY = ivSixteen.getY() - startY;
                            ivSixteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSeventeen")) {
                            if (kindRubbishSeventeen.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSeventeen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSeventeen = current_rubbishSeventeen.substring(current_rubbishSeventeen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSeventeen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSeventeenX = ivSeventeenXDefault;
                            ivSeventeenY = ivSeventeen.getY() - startY;
                            ivSeventeen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivEighteen")) {
                            if (kindRubbishEighteen.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEighteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEighteen = current_rubbishEighteen.substring(current_rubbishEighteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEighteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivEighteenX = ivEighteenXDefault;
                            ivEighteenY = ivEighteen.getY() - startY;
                            ivEighteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivNineteen")) {
                            if (kindRubbishNineteen.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishNineteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishNineteen = current_rubbishNineteen.substring(current_rubbishNineteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishNineteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivNineteenX = ivNineteenXDefault;
                            ivNineteenY = ivNineteen.getY() - startY;
                            ivNineteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwenty")) {
                            if (kindRubbishTwenty.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwenty = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwenty = current_rubbishTwenty.substring(current_rubbishTwenty.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwenty, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyX = ivTwentyXDefault;
                            ivTwentyY = ivTwenty.getY() - startY;
                            ivTwenty.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyOne")) {
                            if (kindRubbishTwentyOne.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyOne = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyOne = current_rubbishTwentyOne.substring(current_rubbishTwentyOne.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyOne, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyOneX = ivTwentyOneXDefault;
                            ivTwentyOneY = ivTwentyOne.getY() - startY;
                            ivTwentyOne.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyTwo")) {
                            if (kindRubbishTwentyTwo.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyTwo = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyTwo = current_rubbishTwentyTwo.substring(current_rubbishTwentyTwo.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyTwo, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyTwoX = ivTwentyTwoXDefault;
                            ivTwentyTwoY = ivTwentyTwo.getY() - startY;
                            ivTwentyTwo.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyThree")) {
                            if (kindRubbishTwentyThree.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyThree = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyThree = current_rubbishTwentyThree.substring(current_rubbishTwentyThree.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyThree, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyThreeX = ivTwentyThreeXDefault;
                            ivTwentyThreeY = ivTwentyThree.getY() - startY;
                            ivTwentyThree.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyFour")) {
                            if (kindRubbishTwentyFour.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyFour = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyFour = current_rubbishTwentyFour.substring(current_rubbishTwentyFour.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyFour, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyFourX = ivTwentyFourXDefault;
                            ivTwentyFourY = ivTwentyFour.getY() - startY;
                            ivTwentyFour.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyFive")) {
                            if (kindRubbishTwentyFive.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyFive = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyFive = current_rubbishTwentyFive.substring(current_rubbishTwentyFive.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyFive, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyFiveX = ivTwentyFiveXDefault;
                            ivTwentyFiveY = ivTwentyFive.getY() - startY;
                            ivTwentyFive.setImageDrawable(drawable);
                        }
                        v.invalidate();
                        return true;

                    case DragEvent.ACTION_DRAG_ENDED:
                        setVisibility();
                        return true;

                    default:
                        break;
                }

                return true;
            }
        });
    }

    public void ivKertasTumbuhan() {
        ivKertasTumbuhan.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();

                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        return true;
                    case DragEvent.ACTION_DRAG_EXITED:
                        return true;
                    case DragEvent.ACTION_DRAG_ENTERED:

                        return true;
                    case DragEvent.ACTION_DROP:
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        String dragData = (String) item.getText();
                        if (dragData.equals("ivOne")) {
                            if (kindRubbishOne.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishOne = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishOne = current_rubbishOne.substring(current_rubbishOne.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishOne, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivOneX = ivOneXDefault;
                            ivOneY = ivOne.getY() - startY;
                            ivOne.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwo")) {

                            if (kindRubbishTwo.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwo = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwo = current_rubbishTwo.substring(current_rubbishTwo.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwo, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwoX = ivTwoXDefault;
                            ivTwoY = ivTwo.getY() - startY;
                            ivTwo.setImageDrawable(drawable);
                        } else if (dragData.equals("ivThree")) {

                            if (kindRubbishThree.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishThree = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishThree = current_rubbishThree.substring(current_rubbishThree.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishThree, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivThreeX = ivThreeXDefault;
                            ivThreeY = ivThree.getY() - startY;
                            ivThree.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFour")) {

                            if (kindRubbishFour.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFour = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFour = current_rubbishFour.substring(current_rubbishFour.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFour, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFourX = ivFourXDefault;
                            ivFourY = ivFour.getY() - startY;
                            ivFour.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFive")) {

                            if (kindRubbishFive.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFive = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFive = current_rubbishFive.substring(current_rubbishFive.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFive, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFiveX = ivFiveXDefault;
                            ivFiveY = ivFive.getY() - startY;
                            ivFive.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSix")) {
                            if (kindRubbishSix.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSix = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSix = current_rubbishSix.substring(current_rubbishSix.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSix, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSixX = ivSixXDefault;
                            ivSixY = ivSix.getY() - startY;
                            ivSix.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSeven")) {
                            if (kindRubbishSeven.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSeven = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSeven = current_rubbishSeven.substring(current_rubbishSeven.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSeven, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSevenX = ivSevenXDefault;
                            ivSevenY = ivSeven.getY() - startY;
                            ivSeven.setImageDrawable(drawable);
                        } else if (dragData.equals("ivEight")) {
                            if (kindRubbishEight.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEight = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEight = current_rubbishEight.substring(current_rubbishEight.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEight, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivEightX = ivEightXDefault;
                            ivEightY = ivEight.getY() - startY;
                            ivEight.setImageDrawable(drawable);
                        } else if (dragData.equals("ivNine")) {
                            if (kindRubbishNine.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishNine = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishNine = current_rubbishNine.substring(current_rubbishNine.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishNine, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivNineX = ivNineXDefault;
                            ivNineY = ivNine.getY() - startY;
                            ivNine.setImageDrawable(drawable);

                        } else if (dragData.equals("ivTen")) {
                            if (kindRubbishTen.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTen = current_rubbishTen.substring(current_rubbishTen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTenX = ivTenXDefault;
                            ivTenY = ivTen.getY() - startY;
                            ivTen.setImageDrawable(drawable);

                        } else if (dragData.equals("ivEleven")) {
                            if (kindRubbishEleven.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEleven = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEleven = current_rubbishEleven.substring(current_rubbishEleven.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEleven, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivElevenX = ivElevenXDefault;
                            ivElevenY = ivEleven.getY() - startY;
                            ivEleven.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwelve")) {

                            if (kindRubbishTwelve.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwelve = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwelve = current_rubbishTwelve.substring(current_rubbishTwelve.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwelve, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwelveX = ivTwelveXDefault;
                            ivTwelveY = ivTwelve.getY() - startY;
                            ivTwelve.setImageDrawable(drawable);
                        } else if (dragData.equals("ivThirteen")) {
                            if (kindRubbishThirteen.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishThirteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishThirteen = current_rubbishThirteen.substring(current_rubbishThirteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishThirteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivThirteenX = ivThirteenXDefault;
                            ivThirteenY = ivThirteen.getY() - startY;
                            ivThirteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFourteen")) {
                            if (kindRubbishFourteen.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFourteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFourteen = current_rubbishFourteen.substring(current_rubbishFourteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFourteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFourteenX = ivFourteenXDefault;
                            ivFourteenY = ivFourteen.getY() - startY;
                            ivFourteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFifteen")) {
                            if (kindRubbishFifteen.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFifteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFifteen = current_rubbishFifteen.substring(current_rubbishFifteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFifteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFifteenX = ivFifteenXDefault;
                            ivFifteenY = ivFifteen.getY() - startY;
                            ivFifteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSixteen")) {
                            if (kindRubbishSixteen.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSixteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSixteen = current_rubbishSixteen.substring(current_rubbishSixteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSixteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSixteenX = ivSixteenXDefault;
                            ivSixteenY = ivSixteen.getY() - startY;
                            ivSixteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSeventeen")) {
                            if (kindRubbishSeventeen.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSeventeen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSeventeen = current_rubbishSeventeen.substring(current_rubbishSeventeen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSeventeen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSeventeenX = ivSeventeenXDefault;
                            ivSeventeenY = ivSeventeen.getY() - startY;
                            ivSeventeen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivEighteen")) {
                            if (kindRubbishEighteen.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEighteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEighteen = current_rubbishEighteen.substring(current_rubbishEighteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEighteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivEighteenX = ivEighteenXDefault;
                            ivEighteenY = ivEighteen.getY() - startY;
                            ivEighteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivNineteen")) {
                            if (kindRubbishNineteen.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishNineteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishNineteen = current_rubbishNineteen.substring(current_rubbishNineteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishNineteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivNineteenX = ivNineteenXDefault;
                            ivNineteenY = ivNineteen.getY() - startY;
                            ivNineteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwenty")) {
                            if (kindRubbishTwenty.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwenty = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwenty = current_rubbishTwenty.substring(current_rubbishTwenty.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwenty, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyX = ivTwentyXDefault;
                            ivTwentyY = ivTwenty.getY() - startY;
                            ivTwenty.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyOne")) {
                            if (kindRubbishTwentyOne.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyOne = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyOne = current_rubbishTwentyOne.substring(current_rubbishTwentyOne.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyOne, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyOneX = ivTwentyOneXDefault;
                            ivTwentyOneY = ivTwentyOne.getY() - startY;
                            ivTwentyOne.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyTwo")) {
                            if (kindRubbishTwentyTwo.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyTwo = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyTwo = current_rubbishTwentyTwo.substring(current_rubbishTwentyTwo.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyTwo, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyTwoX = ivTwentyTwoXDefault;
                            ivTwentyTwoY = ivTwentyTwo.getY() - startY;
                            ivTwentyTwo.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyThree")) {
                            if (kindRubbishTwentyThree.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyThree = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyThree = current_rubbishTwentyThree.substring(current_rubbishTwentyThree.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyThree, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyThreeX = ivTwentyThreeXDefault;
                            ivTwentyThreeY = ivTwentyThree.getY() - startY;
                            ivTwentyThree.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyFour")) {
                            if (kindRubbishTwentyFour.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyFour = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyFour = current_rubbishTwentyFour.substring(current_rubbishTwentyFour.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyFour, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyFourX = ivTwentyFourXDefault;
                            ivTwentyFourY = ivTwentyFour.getY() - startY;
                            ivTwentyFour.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyFive")) {
                            if (kindRubbishTwentyFive.equals("t")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyFive = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyFive = current_rubbishTwentyFive.substring(current_rubbishTwentyFive.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyFive, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyFiveX = ivTwentyFiveXDefault;
                            ivTwentyFiveY = ivTwentyFive.getY() - startY;
                            ivTwentyFive.setImageDrawable(drawable);
                        }
                        v.invalidate();
                        return true;

                    case DragEvent.ACTION_DRAG_ENDED:
                        setVisibility();
                        return true;

                    default:
                        break;
                }

                return true;
            }
        });
    }

    public void ivOrganik() {
        ivOrganik.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();

                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        return true;
                    case DragEvent.ACTION_DRAG_EXITED:
                        return true;
                    case DragEvent.ACTION_DRAG_ENTERED:

                        return true;
                    case DragEvent.ACTION_DROP:
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        String dragData = (String) item.getText();
                        if (dragData.equals("ivOne")) {
                            if (kindRubbishOne.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            ivOneX = ivOneXDefault;
                            ivOneY = ivOne.getY() - startY;
                            current_rubbishOne = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishOne = current_rubbishOne.substring(current_rubbishOne.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishOne, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);


                            ivOne.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwo")) {

                            if (kindRubbishTwo.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwo = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwo = current_rubbishTwo.substring(current_rubbishTwo.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwo, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwoX = ivTwoXDefault;
                            ivTwoY = ivTwo.getY() - startY;
                            ivTwo.setImageDrawable(drawable);
                        } else if (dragData.equals("ivThree")) {

                            if (kindRubbishThree.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishThree = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishThree = current_rubbishThree.substring(current_rubbishThree.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishThree, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivThreeX = ivThreeXDefault;
                            ivThreeY = ivThree.getY() - startY;
                            ivThree.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFour")) {

                            if (kindRubbishFour.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFour = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFour = current_rubbishFour.substring(current_rubbishFour.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFour, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFourX = ivFourXDefault;
                            ivFourY = ivFour.getY() - startY;
                            ivFour.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFive")) {

                            if (kindRubbishFive.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFive = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFive = current_rubbishFive.substring(current_rubbishFive.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFive, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFiveX = ivFiveXDefault;
                            ivFiveY = ivFive.getY() - startY;
                            ivFive.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSix")) {
                            if (kindRubbishSix.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSix = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSix = current_rubbishSix.substring(current_rubbishSix.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSix, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSixX = ivSixXDefault;
                            ivSixY = ivSix.getY() - startY;
                            ivSix.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSeven")) {
                            if (kindRubbishSeven.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSeven = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSeven = current_rubbishSeven.substring(current_rubbishSeven.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSeven, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSevenX = ivSevenXDefault;
                            ivSevenY = ivSeven.getY() - startY;
                            ivSeven.setImageDrawable(drawable);
                        } else if (dragData.equals("ivEight")) {
                            if (kindRubbishEight.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEight = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEight = current_rubbishEight.substring(current_rubbishEight.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEight, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivEightX = ivEightXDefault;
                            ivEightY = ivEight.getY() - startY;
                            ivEight.setImageDrawable(drawable);
                        } else if (dragData.equals("ivNine")) {
                            if (kindRubbishNine.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishNine = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishNine = current_rubbishNine.substring(current_rubbishNine.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishNine, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivNineX = ivNineXDefault;
                            ivNineY = ivNine.getY() - startY;
                            ivNine.setImageDrawable(drawable);

                        } else if (dragData.equals("ivTen")) {
                            if (kindRubbishTen.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTen = current_rubbishTen.substring(current_rubbishTen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTenX = ivTenXDefault;
                            ivTenY = ivTen.getY() - startY;
                            ivTen.setImageDrawable(drawable);

                        } else if (dragData.equals("ivEleven")) {
                            if (kindRubbishEleven.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEleven = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEleven = current_rubbishEleven.substring(current_rubbishEleven.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEleven, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivElevenX = ivElevenXDefault;
                            ivElevenY = ivEleven.getY() - startY;
                            ivEleven.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwelve")) {

                            if (kindRubbishTwelve.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwelve = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwelve = current_rubbishTwelve.substring(current_rubbishTwelve.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwelve, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwelveX = ivTwelveXDefault;
                            ivTwelveY = ivTwelve.getY() - startY;
                            ivTwelve.setImageDrawable(drawable);
                        } else if (dragData.equals("ivThirteen")) {
                            if (kindRubbishThirteen.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishThirteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishThirteen = current_rubbishThirteen.substring(current_rubbishThirteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishThirteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivThirteenX = ivThirteenXDefault;
                            ivThirteenY = ivThirteen.getY() - startY;
                            ivThirteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFourteen")) {
                            if (kindRubbishFourteen.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFourteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFourteen = current_rubbishFourteen.substring(current_rubbishFourteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFourteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFourteenX = ivFourteenXDefault;
                            ivFourteenY = ivFourteen.getY() - startY;
                            ivFourteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFifteen")) {
                            if (kindRubbishFifteen.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFifteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFifteen = current_rubbishFifteen.substring(current_rubbishFifteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFifteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFifteenX = ivFifteenXDefault;
                            ivFifteenY = ivFifteen.getY() - startY;
                            ivFifteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSixteen")) {
                            if (kindRubbishSixteen.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSixteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSixteen = current_rubbishSixteen.substring(current_rubbishSixteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSixteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSixteenX = ivSixteenXDefault;
                            ivSixteenY = ivSixteen.getY() - startY;
                            ivSixteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSeventeen")) {
                            if (kindRubbishSeventeen.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSeventeen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSeventeen = current_rubbishSeventeen.substring(current_rubbishSeventeen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSeventeen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSeventeenX = ivSeventeenXDefault;
                            ivSeventeenY = ivSeventeen.getY() - startY;
                            ivSeventeen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivEighteen")) {
                            if (kindRubbishEighteen.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEighteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEighteen = current_rubbishEighteen.substring(current_rubbishEighteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEighteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivEighteenX = ivEighteenXDefault;
                            ivEighteenY = ivEighteen.getY() - startY;
                            ivEighteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivNineteen")) {
                            if (kindRubbishNineteen.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishNineteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishNineteen = current_rubbishNineteen.substring(current_rubbishNineteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishNineteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivNineteenX = ivNineteenXDefault;
                            ivNineteenY = ivNineteen.getY() - startY;
                            ivNineteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwenty")) {
                            if (kindRubbishTwenty.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwenty = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwenty = current_rubbishTwenty.substring(current_rubbishTwenty.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwenty, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyX = ivTwentyXDefault;
                            ivTwentyY = ivTwenty.getY() - startY;
                            ivTwenty.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyOne")) {
                            if (kindRubbishTwentyOne.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyOne = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyOne = current_rubbishTwentyOne.substring(current_rubbishTwentyOne.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyOne, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyOneX = ivTwentyOneXDefault;
                            ivTwentyOneY = ivTwentyOne.getY() - startY;
                            ivTwentyOne.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyTwo")) {
                            if (kindRubbishTwentyTwo.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyTwo = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyTwo = current_rubbishTwentyTwo.substring(current_rubbishTwentyTwo.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyTwo, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyTwoX = ivTwentyTwoXDefault;
                            ivTwentyTwoY = ivTwentyTwo.getY() - startY;
                            ivTwentyTwo.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyThree")) {
                            if (kindRubbishTwentyThree.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyThree = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyThree = current_rubbishTwentyThree.substring(current_rubbishTwentyThree.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyThree, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyThreeX = ivTwentyThreeXDefault;
                            ivTwentyThreeY = ivTwentyThree.getY() - startY;
                            ivTwentyThree.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyFour")) {
                            if (kindRubbishTwentyFour.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyFour = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyFour = current_rubbishTwentyFour.substring(current_rubbishTwentyFour.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyFour, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyFourX = ivTwentyFourXDefault;
                            ivTwentyFourY = ivTwentyFour.getY() - startY;
                            ivTwentyFour.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyFive")) {
                            if (kindRubbishTwentyFive.equals("o")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyFive = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyFive = current_rubbishTwentyFive.substring(current_rubbishTwentyFive.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyFive, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyFiveX = ivTwentyFiveXDefault;
                            ivTwentyFiveY = ivTwentyFive.getY() - startY;
                            ivTwentyFive.setImageDrawable(drawable);
                        }
                        v.invalidate();
                        return true;

                    case DragEvent.ACTION_DRAG_ENDED:
                        setVisibility();
                        return true;

                    default:
                        break;
                }

                return true;
            }
        });
    }

    public void ivAnorganik() {
        ivAnorganik.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();

                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        return true;
                    case DragEvent.ACTION_DRAG_EXITED:
                        return true;
                    case DragEvent.ACTION_DRAG_ENTERED:

                        return true;
                    case DragEvent.ACTION_DROP:
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        String dragData = (String) item.getText();
                        if (dragData.equals("ivOne")) {
                            if (kindRubbishOne.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            ivOneX = ivOneXDefault;
                            ivOneY = ivOne.getY() - startY;
                            current_rubbishOne = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishOne = current_rubbishOne.substring(current_rubbishOne.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishOne, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);


                            ivOne.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwo")) {

                            if (kindRubbishTwo.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwo = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwo = current_rubbishTwo.substring(current_rubbishTwo.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwo, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwoX = ivTwoXDefault;
                            ivTwoY = ivTwo.getY() - startY;
                            ivTwo.setImageDrawable(drawable);
                        } else if (dragData.equals("ivThree")) {

                            if (kindRubbishThree.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishThree = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishThree = current_rubbishThree.substring(current_rubbishThree.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishThree, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivThreeX = ivThreeXDefault;
                            ivThreeY = ivThree.getY() - startY;
                            ivThree.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFour")) {

                            if (kindRubbishFour.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFour = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFour = current_rubbishFour.substring(current_rubbishFour.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFour, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFourX = ivFourXDefault;
                            ivFourY = ivFour.getY() - startY;
                            ivFour.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFive")) {

                            if (kindRubbishFive.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFive = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFive = current_rubbishFive.substring(current_rubbishFive.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFive, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFiveX = ivFiveXDefault;
                            ivFiveY = ivFive.getY() - startY;
                            ivFive.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSix")) {
                            if (kindRubbishSix.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSix = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSix = current_rubbishSix.substring(current_rubbishSix.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSix, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSixX = ivSixXDefault;
                            ivSixY = ivSix.getY() - startY;
                            ivSix.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSeven")) {
                            if (kindRubbishSeven.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSeven = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSeven = current_rubbishSeven.substring(current_rubbishSeven.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSeven, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSevenX = ivSevenXDefault;
                            ivSevenY = ivSeven.getY() - startY;
                            ivSeven.setImageDrawable(drawable);
                        } else if (dragData.equals("ivEight")) {
                            if (kindRubbishEight.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEight = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEight = current_rubbishEight.substring(current_rubbishEight.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEight, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivEightX = ivEightXDefault;
                            ivEightY = ivEight.getY() - startY;
                            ivEight.setImageDrawable(drawable);
                        } else if (dragData.equals("ivNine")) {
                            if (kindRubbishNine.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishNine = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishNine = current_rubbishNine.substring(current_rubbishNine.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishNine, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivNineX = ivNineXDefault;
                            ivNineY = ivNine.getY() - startY;
                            ivNine.setImageDrawable(drawable);

                        } else if (dragData.equals("ivTen")) {
                            if (kindRubbishTen.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTen = current_rubbishTen.substring(current_rubbishTen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTenX = ivTenXDefault;
                            ivTenY = ivTen.getY() - startY;
                            ivTen.setImageDrawable(drawable);

                        } else if (dragData.equals("ivEleven")) {
                            if (kindRubbishEleven.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEleven = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEleven = current_rubbishEleven.substring(current_rubbishEleven.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEleven, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivElevenX = ivElevenXDefault;
                            ivElevenY = ivEleven.getY() - startY;
                            ivEleven.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwelve")) {

                            if (kindRubbishTwelve.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwelve = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwelve = current_rubbishTwelve.substring(current_rubbishTwelve.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwelve, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwelveX = ivTwelveXDefault;
                            ivTwelveY = ivTwelve.getY() - startY;
                            ivTwelve.setImageDrawable(drawable);
                        } else if (dragData.equals("ivThirteen")) {
                            if (kindRubbishThirteen.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishThirteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishThirteen = current_rubbishThirteen.substring(current_rubbishThirteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishThirteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivThirteenX = ivThirteenXDefault;
                            ivThirteenY = ivThirteen.getY() - startY;
                            ivThirteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFourteen")) {
                            if (kindRubbishFourteen.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFourteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFourteen = current_rubbishFourteen.substring(current_rubbishFourteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFourteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFourteenX = ivFourteenXDefault;
                            ivFourteenY = ivFourteen.getY() - startY;
                            ivFourteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFifteen")) {
                            if (kindRubbishFifteen.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFifteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFifteen = current_rubbishFifteen.substring(current_rubbishFifteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFifteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFifteenX = ivFifteenXDefault;
                            ivFifteenY = ivFifteen.getY() - startY;
                            ivFifteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSixteen")) {
                            if (kindRubbishSixteen.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSixteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSixteen = current_rubbishSixteen.substring(current_rubbishSixteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSixteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSixteenX = ivSixteenXDefault;
                            ivSixteenY = ivSixteen.getY() - startY;
                            ivSixteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSeventeen")) {
                            if (kindRubbishSeventeen.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSeventeen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSeventeen = current_rubbishSeventeen.substring(current_rubbishSeventeen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSeventeen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSeventeenX = ivSeventeenXDefault;
                            ivSeventeenY = ivSeventeen.getY() - startY;
                            ivSeventeen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivEighteen")) {
                            if (kindRubbishEighteen.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEighteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEighteen = current_rubbishEighteen.substring(current_rubbishEighteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEighteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivEighteenX = ivEighteenXDefault;
                            ivEighteenY = ivEighteen.getY() - startY;
                            ivEighteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivNineteen")) {
                            if (kindRubbishNineteen.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishNineteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishNineteen = current_rubbishNineteen.substring(current_rubbishNineteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishNineteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivNineteenX = ivNineteenXDefault;
                            ivNineteenY = ivNineteen.getY() - startY;
                            ivNineteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwenty")) {
                            if (kindRubbishTwenty.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwenty = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwenty = current_rubbishTwenty.substring(current_rubbishTwenty.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwenty, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyX = ivTwentyXDefault;
                            ivTwentyY = ivTwenty.getY() - startY;
                            ivTwenty.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyOne")) {
                            if (kindRubbishTwentyOne.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyOne = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyOne = current_rubbishTwentyOne.substring(current_rubbishTwentyOne.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyOne, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyOneX = ivTwentyOneXDefault;
                            ivTwentyOneY = ivTwentyOne.getY() - startY;
                            ivTwentyOne.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyTwo")) {
                            if (kindRubbishTwentyTwo.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyTwo = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyTwo = current_rubbishTwentyTwo.substring(current_rubbishTwentyTwo.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyTwo, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyTwoX = ivTwentyTwoXDefault;
                            ivTwentyTwoY = ivTwentyTwo.getY() - startY;
                            ivTwentyTwo.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyThree")) {
                            if (kindRubbishTwentyThree.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyThree = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyThree = current_rubbishTwentyThree.substring(current_rubbishTwentyThree.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyThree, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyThreeX = ivTwentyThreeXDefault;
                            ivTwentyThreeY = ivTwentyThree.getY() - startY;
                            ivTwentyThree.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyFour")) {
                            if (kindRubbishTwentyFour.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyFour = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyFour = current_rubbishTwentyFour.substring(current_rubbishTwentyFour.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyFour, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyFourX = ivTwentyFourXDefault;
                            ivTwentyFourY = ivTwentyFour.getY() - startY;
                            ivTwentyFour.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyFive")) {
                            if (kindRubbishTwentyFive.equals("a")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyFive = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyFive = current_rubbishTwentyFive.substring(current_rubbishTwentyFive.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyFive, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyFiveX = ivTwentyFiveXDefault;
                            ivTwentyFiveY = ivTwentyFive.getY() - startY;
                            ivTwentyFive.setImageDrawable(drawable);
                        }
                        v.invalidate();
                        return true;

                    case DragEvent.ACTION_DRAG_ENDED:
                        setVisibility();
                        return true;

                    default:
                        break;
                }

                return true;
            }
        });
    }

    public void ivPlastikTwo() {
        ivPlastikTwo.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();

                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        return true;
                    case DragEvent.ACTION_DRAG_EXITED:
                        return true;
                    case DragEvent.ACTION_DRAG_ENTERED:

                        return true;
                    case DragEvent.ACTION_DROP:
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        String dragData = (String) item.getText();
                        if (dragData.equals("ivOne")) {
                            if (kindRubbishOne.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishOne = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishOne = current_rubbishOne.substring(current_rubbishOne.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishOne, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivOneX = ivOneXDefault;
                            ivOneY = ivOne.getY() - startY;
                            ivOne.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwo")) {

                            if (kindRubbishTwo.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwo = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwo = current_rubbishTwo.substring(current_rubbishTwo.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwo, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwoX = ivTwoXDefault;
                            ivTwoY = ivTwo.getY() - startY;
                            ivTwo.setImageDrawable(drawable);
                        } else if (dragData.equals("ivThree")) {

                            if (kindRubbishThree.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishThree = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishThree = current_rubbishThree.substring(current_rubbishThree.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishThree, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivThreeX = ivThreeXDefault;
                            ivThreeY = ivThree.getY() - startY;
                            ivThree.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFour")) {

                            if (kindRubbishFour.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFour = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFour = current_rubbishFour.substring(current_rubbishFour.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFour, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFourX = ivFourXDefault;
                            ivFourY = ivFour.getY() - startY;
                            ivFour.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFive")) {

                            if (kindRubbishFive.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFive = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFive = current_rubbishFive.substring(current_rubbishFive.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFive, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFiveX = ivFiveXDefault;
                            ivFiveY = ivFive.getY() - startY;
                            ivFive.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSix")) {
                            if (kindRubbishSix.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSix = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSix = current_rubbishSix.substring(current_rubbishSix.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSix, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSixX = ivSixXDefault;
                            ivSixY = ivSix.getY() - startY;
                            ivSix.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSeven")) {
                            if (kindRubbishSeven.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSeven = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSeven = current_rubbishSeven.substring(current_rubbishSeven.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSeven, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSevenX = ivSevenXDefault;
                            ivSevenY = ivSeven.getY() - startY;
                            ivSeven.setImageDrawable(drawable);
                        } else if (dragData.equals("ivEight")) {
                            if (kindRubbishEight.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEight = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEight = current_rubbishEight.substring(current_rubbishEight.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEight, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivEightX = ivEightXDefault;
                            ivEightY = ivEight.getY() - startY;
                            ivEight.setImageDrawable(drawable);
                        } else if (dragData.equals("ivNine")) {
                            if (kindRubbishNine.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishNine = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishNine = current_rubbishNine.substring(current_rubbishNine.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishNine, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivNineX = ivNineXDefault;
                            ivNineY = ivNine.getY() - startY;
                            ivNine.setImageDrawable(drawable);

                        } else if (dragData.equals("ivTen")) {
                            if (kindRubbishTen.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTen = current_rubbishTen.substring(current_rubbishTen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTenX = ivTenXDefault;
                            ivTenY = ivTen.getY() - startY;
                            ivTen.setImageDrawable(drawable);

                        } else if (dragData.equals("ivEleven")) {
                            if (kindRubbishEleven.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEleven = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEleven = current_rubbishEleven.substring(current_rubbishEleven.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEleven, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivElevenX = ivElevenXDefault;
                            ivElevenY = ivEleven.getY() - startY;
                            ivEleven.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwelve")) {

                            if (kindRubbishTwelve.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwelve = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwelve = current_rubbishTwelve.substring(current_rubbishTwelve.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwelve, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwelveX = ivTwelveXDefault;
                            ivTwelveY = ivTwelve.getY() - startY;
                            ivTwelve.setImageDrawable(drawable);
                        } else if (dragData.equals("ivThirteen")) {
                            if (kindRubbishThirteen.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishThirteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishThirteen = current_rubbishThirteen.substring(current_rubbishThirteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishThirteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivThirteenX = ivThirteenXDefault;
                            ivThirteenY = ivThirteen.getY() - startY;
                            ivThirteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFourteen")) {
                            if (kindRubbishFourteen.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFourteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFourteen = current_rubbishFourteen.substring(current_rubbishFourteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFourteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFourteenX = ivFourteenXDefault;
                            ivFourteenY = ivFourteen.getY() - startY;
                            ivFourteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivFifteen")) {
                            if (kindRubbishFifteen.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishFifteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishFifteen = current_rubbishFifteen.substring(current_rubbishFifteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishFifteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivFifteenX = ivFifteenXDefault;
                            ivFifteenY = ivFifteen.getY() - startY;
                            ivFifteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSixteen")) {
                            if (kindRubbishSixteen.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSixteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSixteen = current_rubbishSixteen.substring(current_rubbishSixteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSixteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSixteenX = ivSixteenXDefault;
                            ivSixteenY = ivSixteen.getY() - startY;
                            ivSixteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivSeventeen")) {
                            if (kindRubbishSeventeen.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishSeventeen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishSeventeen = current_rubbishSeventeen.substring(current_rubbishSeventeen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishSeventeen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivSeventeenX = ivSeventeenXDefault;
                            ivSeventeenY = ivSeventeen.getY() - startY;
                            ivSeventeen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivEighteen")) {
                            if (kindRubbishEighteen.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishEighteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishEighteen = current_rubbishEighteen.substring(current_rubbishEighteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishEighteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivEighteenX = ivEighteenXDefault;
                            ivEighteenY = ivEighteen.getY() - startY;
                            ivEighteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivNineteen")) {
                            if (kindRubbishNineteen.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishNineteen = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishNineteen = current_rubbishNineteen.substring(current_rubbishNineteen.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishNineteen, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivNineteenX = ivNineteenXDefault;
                            ivNineteenY = ivNineteen.getY() - startY;
                            ivNineteen.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwenty")) {
                            if (kindRubbishTwenty.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwenty = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwenty = current_rubbishTwenty.substring(current_rubbishTwenty.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwenty, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyX = ivTwentyXDefault;
                            ivTwentyY = ivTwenty.getY() - startY;
                            ivTwenty.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyOne")) {
                            if (kindRubbishTwentyOne.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyOne = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyOne = current_rubbishTwentyOne.substring(current_rubbishTwentyOne.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyOne, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyOneX = ivTwentyOneXDefault;
                            ivTwentyOneY = ivTwentyOne.getY() - startY;
                            ivTwentyOne.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyTwo")) {
                            if (kindRubbishTwentyTwo.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyTwo = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyTwo = current_rubbishTwentyTwo.substring(current_rubbishTwentyTwo.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyTwo, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyTwoX = ivTwentyTwoXDefault;
                            ivTwentyTwoY = ivTwentyTwo.getY() - startY;
                            ivTwentyTwo.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyThree")) {
                            if (kindRubbishTwentyThree.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyThree = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyThree = current_rubbishTwentyThree.substring(current_rubbishTwentyThree.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyThree, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyThreeX = ivTwentyThreeXDefault;
                            ivTwentyThreeY = ivTwentyThree.getY() - startY;
                            ivTwentyThree.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyFour")) {
                            if (kindRubbishTwentyFour.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyFour = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyFour = current_rubbishTwentyFour.substring(current_rubbishTwentyFour.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyFour, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyFourX = ivTwentyFourXDefault;
                            ivTwentyFourY = ivTwentyFour.getY() - startY;
                            ivTwentyFour.setImageDrawable(drawable);
                        } else if (dragData.equals("ivTwentyFive")) {
                            if (kindRubbishTwentyFive.equals("p")) {
                                score += 10;
                            } else {
                                miss++;
                            }
                            current_rubbishTwentyFive = img_rubbish[r.nextInt(img_rubbish.length)];
                            kindRubbishTwentyFive = current_rubbishTwentyFive.substring(current_rubbishTwentyFive.length() - 1);
                            Resources res = getResources();
                            int resID = res.getIdentifier(current_rubbishTwentyFive, "drawable", getPackageName());
                            Drawable drawable = res.getDrawable(resID);

                            ivTwentyFiveX = ivTwentyFiveXDefault;
                            ivTwentyFiveY = ivTwentyFive.getY() - startY;
                            ivTwentyFive.setImageDrawable(drawable);
                        }
                        v.invalidate();
                        return true;

                    case DragEvent.ACTION_DRAG_ENDED:
                        setVisibility();

                        return true;

                    default:
                        break;
                }

                return true;
            }
        });
    }

    public void initViews() {
        ivOne = findViewById(R.id.ivOne);
        ivTwo = findViewById(R.id.ivTwo);
        ivThree = findViewById(R.id.ivThree);
        ivFour = findViewById(R.id.ivFour);
        ivFive = findViewById(R.id.ivFive);
        ivSix = findViewById(R.id.ivSix);
        ivSeven = findViewById(R.id.ivSeven);
        ivEight = findViewById(R.id.ivEight);
        ivNine = findViewById(R.id.ivNine);
        ivTen = findViewById(R.id.ivTen);
        ivEleven = findViewById(R.id.ivEleven);
        ivTwelve = findViewById(R.id.ivTwelve);
        ivThirteen = findViewById(R.id.ivThirteen);
        ivFourteen = findViewById(R.id.ivFourteen);
        ivFifteen = findViewById(R.id.ivFifteen);
        ivSixteen = findViewById(R.id.ivSixteen);
        ivSeventeen = findViewById(R.id.ivSeventeen);
        ivEighteen = findViewById(R.id.ivEighteen);

        ivNineteen = findViewById(R.id.ivNineteen);
        ivTwenty = findViewById(R.id.ivTwenty);
        ivTwentyOne = findViewById(R.id.ivTwentyOne);
        ivTwentyTwo = findViewById(R.id.ivTwentyTwo);
        ivTwentyThree = findViewById(R.id.ivTwentyThree);
        ivTwentyFour = findViewById(R.id.ivTwentyFour);
        ivTwentyFive = findViewById(R.id.ivTwentyFive);

        ivOrganik = findViewById(R.id.ivOrganik);
        ivAnorganik = findViewById(R.id.ivAnorganik);
        ivPlastikTwo = findViewById(R.id.ivPlastikTwo);
        ivLogam = findViewById(R.id.ivLogam);
        ivKaca = findViewById(R.id.ivKaca);
        ivPlastik = findViewById(R.id.ivPlastik);
        ivKertasTumbuhan = findViewById(R.id.ivKertasTumbuhan);

        btnStartPause = findViewById(R.id.btnStartPause);
        btnExit = findViewById(R.id.btnExit);
        tvViewCountdown = findViewById(R.id.tvViewCountdown);
        tvUsername = findViewById(R.id.tvUsername);
        tvLevel = findViewById(R.id.tvLevel);
        tvMiss = findViewById(R.id.tvMiss);

        llOrganik = findViewById(R.id.llOrganik);
        llAnorganik = findViewById(R.id.llAnorganik);
        llPlastikTwo = findViewById(R.id.llPlastikTwo);
        llLogam = findViewById(R.id.llLogam);
        llKaca = findViewById(R.id.llKaca);
        llPlastik = findViewById(R.id.llPlastik);
        llKertasTumbuhan = findViewById(R.id.llKertasTumbuhan);

        soundPlayer = new SoundPlayer(this);

        clStatusGame = findViewById(R.id.clStatusGame);

        r = new Random();

        res = getResources();
    }

    public void ivOne() {
        ivOneY += speed;
        if (ivOneY > frameHeight) {
            score -= 2;
            ivOne.setVisibility(View.GONE);
        }
        ivOne.setX(ivOneX);
        ivOne.setY(ivOneY);
    }

    public void ivTwo() {
        ivTwoY += speed;

        if (ivTwoY > frameHeight) {
            score -= 2;
            ivTwo.setVisibility(View.GONE);
        }
        ivTwo.setX(ivTwoX);
        ivTwo.setY(ivTwoY);
    }

    public void ivThree() {
        ivThreeY += speed;

        if (ivThreeY > frameHeight) {
            score -= 2;
            ivThree.setVisibility(View.GONE);
        }
        ivThree.setX(ivThreeX);
        ivThree.setY(ivThreeY);
    }

    public void ivFour() {
        ivFourY += speed;

        if (ivFourY > frameHeight) {
            score -= 2;
            ivFour.setVisibility(View.GONE);
        }
        ivFour.setX(ivFourX);
        ivFour.setY(ivFourY);
    }

    public void ivFive() {
        ivFiveY += speed;

        if (ivFiveY > frameHeight) {
            score -= 2;
            ivFive.setVisibility(View.GONE);
        }
        ivFive.setX(ivFiveX);
        ivFive.setY(ivFiveY);
    }

    public void ivSix() {
        ivSixY += speed;
        if (ivSixY > frameHeight) {
            score -= 2;
            ivSix.setVisibility(View.GONE);
        }
        ivSix.setX(ivSixX);
        ivSix.setY(ivSixY);
    }

    public void ivSeven() {
        ivSevenY += speed;

        if (ivSevenY > frameHeight) {
            score -= 2;
            ivSeven.setVisibility(View.GONE);
        }
        ivSeven.setX(ivSevenX);
        ivSeven.setY(ivSevenY);
    }

    public void ivEight() {
        ivEightY += speed;

        if (ivEightY > frameHeight) {
            score -= 2;
            ivEight.setVisibility(View.GONE);
        }
        ivEight.setX(ivEightX);
        ivEight.setY(ivEightY);
    }

    public void ivNine() {
        ivNineY += speed;

        if (ivNineY > frameHeight) {
            score -= 2;
            ivNine.setVisibility(View.GONE);
        }
        ivNine.setX(ivNineX);
        ivNine.setY(ivNineY);
    }

    public void ivTen() {
        ivTenY += speed;

        if (ivTenY > frameHeight) {
            score -= 2;
            ivTen.setVisibility(View.GONE);
        }
        ivTen.setX(ivTenX);
        ivTen.setY(ivTenY);
    }

    public void ivEleven() {
        ivElevenY += speed;

        if (ivElevenY > frameHeight) {
            score -= 2;
            ivEleven.setVisibility(View.GONE);
        }
        ivEleven.setX(ivElevenX);
        ivEleven.setY(ivElevenY);
    }

    public void ivTwelve() {
        ivTwelveY += speed;

        if (ivTwelveY > frameHeight) {
            score -= 2;
            ivTwelve.setVisibility(View.GONE);
        }
        ivTwelve.setX(ivTwelveX);
        ivTwelve.setY(ivTwelveY);
    }

    public void ivThirteen() {
        ivThirteenY += speed;

        if (ivThirteenY > frameHeight) {
            score -= 2;
            ivThirteen.setVisibility(View.GONE);
        }
        ivThirteen.setX(ivThirteenX);
        ivThirteen.setY(ivThirteenY);
    }

    public void ivFourteen() {
        ivFourteenY += speed;

        if (ivFourteenY > frameHeight) {
            score -= 2;
            ivFourteen.setVisibility(View.GONE);
        }
        ivFourteen.setX(ivFourteenX);
        ivFourteen.setY(ivFourteenY);
    }

    public void ivFifteen() {
        ivFifteenY += speed;

        if (ivFifteenY > frameHeight) {
            score -= 2;
            ivFifteen.setVisibility(View.GONE);
        }
        ivFifteen.setX(ivFifteenX);
        ivFifteen.setY(ivFifteenY);
    }

    public void ivSixteen() {
        ivSixteenY += speed;

        if (ivSixteenY > frameHeight) {
            score -= 2;
            ivSixteen.setVisibility(View.GONE);
        }
        ivSixteen.setX(ivSixteenX);
        ivSixteen.setY(ivSixteenY);
    }

    public void ivSeventeen() {
        ivSeventeenY += speed;

        if (ivSeventeenY > frameHeight) {
            score -= 2;
            ivSeventeen.setVisibility(View.GONE);
        }
        ivSeventeen.setX(ivSeventeenX);
        ivSeventeen.setY(ivSeventeenY);
    }

    public void ivEighteen() {
        ivEighteenY += speed;

        if (ivEighteenY > frameHeight) {
            score -= 2;
            ivEighteen.setVisibility(View.GONE);
        }
        ivEighteen.setX(ivEighteenX);
        ivEighteen.setY(ivEighteenY);
    }

    public void ivNineteen() {
        ivNineteenY += speed;
        if (ivNineteenY > frameHeight) {
            score -= 2;
            ivNineteen.setVisibility(View.GONE);
        }
        ivNineteen.setX(ivNineteenX);
        ivNineteen.setY(ivNineteenY);
    }

    public void ivTwenty() {
        ivTwentyY += speed;
        if (ivTwentyY > frameHeight) {
            score -= 2;
            ivTwenty.setVisibility(View.GONE);
        }
        ivTwenty.setX(ivTwentyX);
        ivTwenty.setY(ivTwentyY);
    }

    public void ivTwentyOne() {
        ivTwentyOneY += speed;
        if (ivSixY > frameHeight) {
            score -= 2;
            ivTwentyOne.setVisibility(View.GONE);
        }
        ivTwentyOne.setX(ivTwentyOneX);
        ivTwentyOne.setY(ivTwentyOneY);
    }

    public void ivTwentyTwo() {
        ivTwentyTwoY += speed;
        if (ivTwentyTwoY > frameHeight) {
            score -= 2;
            ivTwentyTwo.setVisibility(View.GONE);
        }
        ivTwentyTwo.setX(ivTwentyTwoX);
        ivTwentyTwo.setY(ivTwentyTwoY);
    }

    public void ivTwentyThree() {
        ivTwentyThreeY += speed;
        if (ivTwentyThreeY > frameHeight) {
            score -= 2;
            ivTwentyThree.setVisibility(View.GONE);
        }
        ivTwentyThree.setX(ivTwentyThreeX);
        ivTwentyThree.setY(ivTwentyThreeY);
    }

    public void ivTwentyFour() {
        ivTwentyFourY += speed;
        if (ivTwentyFourY > frameHeight) {
            score -= 2;
            ivTwentyFour.setVisibility(View.GONE);
        }
        ivTwentyFour.setX(ivTwentyFourX);
        ivTwentyFour.setY(ivTwentyFourY);
    }

    public void ivTwentyFive() {
        ivTwentyFiveY += speed;
        if (ivTwentyFiveY > frameHeight) {
            score -= 2;
            ivTwentyFive.setVisibility(View.GONE);
        }
        ivTwentyFive.setX(ivTwentyFiveX);
        ivTwentyFive.setY(ivTwentyFiveY);
    }


    public void startGame(View view) {
        startLayout.setVisibility(View.INVISIBLE);
        clStatusGame.setVisibility(View.VISIBLE);

        if (level == 3) {
            speed = 10;
            llOrganik.setVisibility(View.GONE);
            llAnorganik.setVisibility(View.GONE);
            llPlastikTwo.setVisibility(View.GONE);

            llLogam.setVisibility(View.VISIBLE);
            llKaca.setVisibility(View.VISIBLE);
            llPlastik.setVisibility(View.VISIBLE);
            llKertasTumbuhan.setVisibility(View.VISIBLE);
        } else if (level == 2) {
            llPlastikTwo.setVisibility(View.VISIBLE);
            speed = 10;
        } else if (level == 1) {
            speed = 5;
        }

        if (frameHeight == 0) {
            frameHeight = gameFrame.getHeight();
            frameWidth = gameFrame.getWidth();
            initialFrameWidth = frameWidth;
        }


        frameWidth = initialFrameWidth;

        setY();
        getY();
        setVisibility();

        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;

                updateCountDownText();

                if (level == 1) {
                    ivOne();
                    ivTwo();
                    ivThree();
                    ivFour();
                    ivFive();
                    ivSix();
                    ivSeven();
                    ivEight();
                    ivNine();
                    ivTen();
                    ivEleven();
                    ivTwelve();
                    ivThirteen();
                    ivFourteen();
                    ivFifteen();
                    ivSixteen();
                    ivSeventeen();
                    ivEighteen();
                    ivNineteen();
                    ivTwenty();
                    ivTwentyOne();
                    ivTwentyTwo();
                    ivTwentyThree();
                    ivTwentyFour();
                    ivTwentyFive();


                } else if (level == 2) {
                    ivOne();
                    ivTwo();
                    ivThree();
                    ivFour();
                    ivFive();
                    ivSix();
                    ivSeven();
                    ivEight();
                    ivNine();
                    ivTen();
                    ivEleven();
                    ivTwelve();
                    ivThirteen();
                    ivFourteen();
                    ivFifteen();
                    ivSixteen();
                    ivSeventeen();
                    ivEighteen();
                    ivNineteen();
                    ivTwenty();
                    ivTwentyOne();
                    ivTwentyTwo();
                    ivTwentyThree();
                    ivTwentyFour();
                    ivTwentyFive();
                } else if (level == 3) {
                    ivOne();
                    ivTwo();
                    ivThree();
                    ivFour();
                    ivFive();
                    ivSix();
                    ivSeven();
                    ivEight();
                    ivNine();
                    ivTen();
                    ivEleven();
                    ivTwelve();
                    ivThirteen();
                    ivFourteen();
                    ivFifteen();
                    ivSixteen();
                    ivSeventeen();
                    ivEighteen();
                    ivNineteen();
                    ivTwenty();
                    ivTwentyOne();
                    ivTwentyTwo();
                    ivTwentyThree();
                    ivTwentyFour();
                }
                if (miss > current_miss) {
                    soundPlayer.playHitBlackSound();
                    current_miss = miss;
                }
                if (score > current_scoress) {
                    soundPlayer.playHitOrangeSound();
                    current_scoress = score;
                }

                if (miss == 3) {
                    int color = R.color.colorForegroundHigh;
                    gameFrame.setForeground(new ColorDrawable(ContextCompat.getColor(getBaseContext(), color)));
                } else if (miss == 7) {
                    mCountDownTimer.cancel();
                    if (score > highScore) {
                        highScore = score;
                    }
                    Toast.makeText(MainActivity.this, "Level belum berhasil, Coba lagi!" + String.valueOf(mTimeLeftInMillis), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, WinLose.class);
                    intent.putExtra("message", "Level belum berhasil, Coba lagi!");
                    intent.putExtra("time", 1L);
                    intent.putExtra("level", level);
                    intent.putExtra("score", highScore);
                    startActivity(intent);
                }

                if (score < 0) {
                    mCountDownTimer.cancel();
                    Toast.makeText(MainActivity.this, "Level belum berhasil, Coba lagi!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, WinLose.class);
                    intent.putExtra("message", "Level belum berhasil, Coba lagi!");
                    intent.putExtra("time", 1);
                    intent.putExtra("level", level);
                    intent.putExtra("score", highScore);
                    startActivity(intent);
                }

                if (score >= 1000 && level == 3) {
                    mCountDownTimer.cancel();
                    if (score > highScore) {
                        highScore = score;
                    }
                    Toast.makeText(MainActivity.this, "Level 3 berhasil!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, WinLose.class);
                    intent.putExtra("message", "Level 3 berhasil!");
                    intent.putExtra("time", mTimeLeftInMillis);
                    intent.putExtra("level", 3);
                    intent.putExtra("score", highScore);
                    startActivity(intent);
                } else if (score >= 700 && level == 2) {
                    mCountDownTimer.cancel();
                    if (score > highScore) {
                        highScore = score;
                    }
                    Toast.makeText(MainActivity.this, "Level 2 berhasil!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, WinLose.class);
                    intent.putExtra("message", "Level 2 berhasil!");
                    intent.putExtra("time", mTimeLeftInMillis);
                    intent.putExtra("level", 2);
                    intent.putExtra("score", highScore);
                    startActivity(intent);
                } else if (score >= 500 && level == 1) {
                    mCountDownTimer.cancel();
                    if (score > highScore) {
                        highScore = score;
                    }
                    Toast.makeText(MainActivity.this, "Level 1 berhasil!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, WinLose.class);
                    intent.putExtra("message", "Level 1 berhasil!");
                    intent.putExtra("time", mTimeLeftInMillis);
                    intent.putExtra("level", 1);
                    intent.putExtra("score", highScore);
                    startActivity(intent);
                }
                scoreLabel.setText("Score : " + score);
                tvUsername.setText(usernameS);
                tvLevel.setText("Level : " + level);
                tvMiss.setText("Miss : " + miss);
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mCountDownTimer.cancel();
                if (score > highScore) {
                    highScore = score;
                }
                Toast.makeText(MainActivity.this, "Waktu telah Habis!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, WinLose.class);
                intent.putExtra("message", "Waktu telah habis!");
                intent.putExtra("time", mTimeLeftInMillis);
                intent.putExtra("level", 1);
                intent.putExtra("score", highScore);
                startActivity(intent);
            }
        }.start();

        mTimerRunning = true;
    }

    public void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormated = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        tvViewCountdown.setText(timeLeftFormated);

    }

    public void setY() {
        ivOne.setY(0.0f);
        ivTwo.setY(-10.0f);
        ivThree.setY(-20.0f);
        ivFour.setY(-40.0f);
        ivFive.setY(-50.0f);

        ivSix.setY(-100.0f);
        ivSeven.setY(-110.0f);
        ivEight.setY(-120.0f);
        ivNine.setY(-130.0f);
        ivTen.setY(-140.0f);

        ivEleven.setY(-200.0f);
        ivTwelve.setY(-210.0f);
        ivThirteen.setY(-220.0f);
        ivFourteen.setY(-230.0f);
        ivFifteen.setY(-240.0f);

        ivSixteen.setY(-300.0f);
        ivSeventeen.setY(-310.0f);
        ivEighteen.setY(-320.0f);
        ivNineteen.setY(-330.0f);
        ivTwenty.setY(-340.0f);

        ivTwentyOne.setY(-400.0f);
        ivTwentyTwo.setY(-410.0f);
        ivTwentyThree.setY(-420.0f);
        ivTwentyFour.setY(-430.0f);
        ivTwentyFive.setY(-440.0f);

        ivOne.setX(0.0f);
        ivTwo.setX(150.0f);
        ivThree.setX(300.0f);
        ivFour.setX(450.0f);
        ivFive.setX(600.0f);

        ivSix.setX(0.0f);
        ivSeven.setX(150.0f);
        ivEight.setX(300.0f);
        ivNine.setX(450.0f);
        ivTen.setX(600.0f);

        ivEleven.setX(0.0f);
        ivTwelve.setX(150.0f);
        ivThirteen.setX(300.0f);
        ivFourteen.setX(450.0f);
        ivFifteen.setX(600.0f);

        ivSixteen.setX(0.0f);
        ivSeventeen.setX(150.0f);
        ivEighteen.setX(300.0f);
        ivNineteen.setX(450.0f);
        ivTwenty.setX(600.0f);

        ivTwentyOne.setX(0.0f);
        ivTwentyTwo.setX(150.0f);
        ivTwentyThree.setX(300.0f);
        ivTwentyFour.setX(450.0f);
        ivTwentyFive.setX(600.0f);

        if (level == 3) {
            ivOne.setY(0.0f);
            ivTwo.setY(-10.0f);
            ivThree.setY(-20.0f);
            ivFour.setY(-30.0f);
            ivFive.setY(-40.0f);
            ivSix.setY(-50.0f);
            ivSeven.setY(-60.0f);
            ivEight.setY(-70.0f);

            ivNine.setY(-100.0f);
            ivTen.setY(-110.0f);
            ivEleven.setY(-120.0f);
            ivTwelve.setY(-130.0f);
            ivThirteen.setY(-140.0f);
            ivFourteen.setY(-150.0f);
            ivFifteen.setY(-160.0f);
            ivSixteen.setY(-170.0f);

            ivSeventeen.setY(-200.0f);
            ivEighteen.setY(-210.0f);
            ivNineteen.setY(-220.0f);
            ivTwenty.setY(-230.0f);
            ivTwentyOne.setY(-240.0f);
            ivTwentyTwo.setY(-250.0f);
            ivTwentyThree.setY(-260.0f);
            ivTwentyFour.setY(-270.0f);

            ivOne.setX(0.0f);
            ivTwo.setX(100.0f);
            ivThree.setX(200.0f);
            ivFour.setX(300.0f);
            ivFive.setX(400.0f);
            ivSix.setX(500.0f);
            ivSeven.setX(600.0f);
            ivEight.setX(700.0f);

            ivNine.setX(0.0f);
            ivTen.setX(100.0f);
            ivEleven.setX(200.0f);
            ivTwelve.setX(300.0f);
            ivThirteen.setX(400.0f);
            ivFourteen.setX(500.0f);
            ivFifteen.setX(600.0f);
            ivSixteen.setX(700.0f);

            ivSeventeen.setX(0.0f);
            ivEighteen.setX(100.0f);
            ivNineteen.setX(200.0f);
            ivTwenty.setX(300.0f);
            ivTwentyOne.setX(400.0f);
            ivTwentyTwo.setX(500.0f);
            ivTwentyThree.setX(600.0f);
            ivTwentyFour.setX(700.0f);
        }

        Resources resOne = getResources();
        int resIDOne = resOne.getIdentifier(current_rubbishOne, "drawable", getPackageName());
        Drawable drawableOne = resOne.getDrawable(resIDOne);
        ivOne.setImageDrawable(drawableOne);

        Resources resTwo = getResources();
        int resIDTwo = resTwo.getIdentifier(current_rubbishTwo, "drawable", getPackageName());
        Drawable drawableTwo = resTwo.getDrawable(resIDTwo);
        ivTwo.setImageDrawable(drawableTwo);

        Resources resThree = getResources();
        int resIDThree = resThree.getIdentifier(current_rubbishThree, "drawable", getPackageName());
        Drawable drawableThree = resThree.getDrawable(resIDThree);
        ivThree.setImageDrawable(drawableThree);

        Resources resFour = getResources();
        int resIDFour = resFour.getIdentifier(current_rubbishFour, "drawable", getPackageName());
        Drawable drawableFour = resFour.getDrawable(resIDFour);
        ivFour.setImageDrawable(drawableFour);

        Resources resFive = getResources();
        int resIDFive = resFive.getIdentifier(current_rubbishFive, "drawable", getPackageName());
        Drawable drawableFive = resFive.getDrawable(resIDFive);
        ivFive.setImageDrawable(drawableFive);

        Resources resSix = getResources();
        int resIDSix = resSix.getIdentifier(current_rubbishSix, "drawable", getPackageName());
        Drawable drawableSix = resSix.getDrawable(resIDSix);
        ivSix.setImageDrawable(drawableSix);

        Resources resSeven = getResources();
        int resIDSeven = resSeven.getIdentifier(current_rubbishSeven, "drawable", getPackageName());
        Drawable drawableSeven = resSeven.getDrawable(resIDSeven);
        ivSeven.setImageDrawable(drawableSeven);

        Resources resEight = getResources();
        int resIDEight = resEight.getIdentifier(current_rubbishEight, "drawable", getPackageName());
        Drawable drawableEight = resEight.getDrawable(resIDEight);
        ivEight.setImageDrawable(drawableEight);

        Resources resNine = getResources();
        int resIDNine = resNine.getIdentifier(current_rubbishNine, "drawable", getPackageName());
        Drawable drawableNine = resNine.getDrawable(resIDNine);
        ivNine.setImageDrawable(drawableNine);

        Resources resTen = getResources();
        int resIDTen = resTen.getIdentifier(current_rubbishTen, "drawable", getPackageName());
        Drawable drawableTen = resTen.getDrawable(resIDTen);
        ivTen.setImageDrawable(drawableTen);

        Resources resEleven = getResources();
        int resIDEleven = resEleven.getIdentifier(current_rubbishEleven, "drawable", getPackageName());
        Drawable drawableEleven = resEleven.getDrawable(resIDEleven);
        ivEleven.setImageDrawable(drawableEleven);

        Resources resTwelve = getResources();
        int resIDTwelve = resTwelve.getIdentifier(current_rubbishTwelve, "drawable", getPackageName());
        Drawable drawableTwelve = resTwelve.getDrawable(resIDTwelve);
        ivTwelve.setImageDrawable(drawableTwelve);

        Resources resThirteen = getResources();
        int resIDThirteen = resThirteen.getIdentifier(current_rubbishThirteen, "drawable", getPackageName());
        Drawable drawableThirteen = resThirteen.getDrawable(resIDThirteen);
        ivThirteen.setImageDrawable(drawableThirteen);

        Resources resFourteen = getResources();
        int resIDFourteen = resFourteen.getIdentifier(current_rubbishFourteen, "drawable", getPackageName());
        Drawable drawableFourteen = resFourteen.getDrawable(resIDFourteen);
        ivFourteen.setImageDrawable(drawableFourteen);

        Resources resFifteen = getResources();
        int resIDFifteen = resFifteen.getIdentifier(current_rubbishFifteen, "drawable", getPackageName());
        Drawable drawableFifteen = resFifteen.getDrawable(resIDFifteen);
        ivFifteen.setImageDrawable(drawableFifteen);

        Resources resSixteen = getResources();
        int resIDSixteen = resSixteen.getIdentifier(current_rubbishSixteen, "drawable", getPackageName());
        Drawable drawableSixteen = resSixteen.getDrawable(resIDSixteen);
        ivSixteen.setImageDrawable(drawableSixteen);

        Resources resSeventeen = getResources();
        int resIDSeventeen = resSeventeen.getIdentifier(current_rubbishSeventeen, "drawable", getPackageName());
        Drawable drawableSeventeen = resSeventeen.getDrawable(resIDSeventeen);
        ivSeventeen.setImageDrawable(drawableSeventeen);

        Resources resEighteen = getResources();
        int resIDEighteen = resEighteen.getIdentifier(current_rubbishEighteen, "drawable", getPackageName());
        Drawable drawableEighteen = resEighteen.getDrawable(resIDEighteen);
        ivEighteen.setImageDrawable(drawableEighteen);


        Resources resNineteen = getResources();
        int resIDNineteen = resNineteen.getIdentifier(current_rubbishNineteen, "drawable", getPackageName());
        Drawable drawableNineteen = resNineteen.getDrawable(resIDNineteen);
        ivNineteen.setImageDrawable(drawableNineteen);

        Resources resTwenty = getResources();
        int resIDTwenty = resTwenty.getIdentifier(current_rubbishTwenty, "drawable", getPackageName());
        Drawable drawableTwenty = resTwenty.getDrawable(resIDTwenty);
        ivTwenty.setImageDrawable(drawableTwenty);

        Resources resTwentyOne = getResources();
        int resIDTwentyOne = resTwentyOne.getIdentifier(current_rubbishTwentyOne, "drawable", getPackageName());
        Drawable drawableTwentyOne = resTwentyOne.getDrawable(resIDTwentyOne);
        ivTwentyOne.setImageDrawable(drawableTwentyOne);

        Resources resTwentyTwo = getResources();
        int resIDTwentyTwo = resTwentyTwo.getIdentifier(current_rubbishTwentyTwo, "drawable", getPackageName());
        Drawable drawableTwentyTwo = resTwentyTwo.getDrawable(resIDTwentyTwo);
        ivTwentyTwo.setImageDrawable(drawableTwentyTwo);

        Resources resTwentyThree = getResources();
        int resIDTwentyThree = resTwentyThree.getIdentifier(current_rubbishTwentyThree, "drawable", getPackageName());
        Drawable drawableTwentyThree = resTwentyThree.getDrawable(resIDTwentyThree);
        ivTwentyThree.setImageDrawable(drawableTwentyThree);

        Resources resTwentyFour = getResources();
        int resIDTwentyFour = resTwentyFour.getIdentifier(current_rubbishTwentyFour, "drawable", getPackageName());
        Drawable drawableTwentyFour = resTwentyFour.getDrawable(resIDTwentyFour);
        ivTwentyFour.setImageDrawable(drawableTwentyFour);

        Resources resTwentyFive = getResources();
        int resIDTwentyFive = resTwentyFive.getIdentifier(current_rubbishTwentyFive, "drawable", getPackageName());
        Drawable drawableTwentyFive = resTwentyFive.getDrawable(resIDTwentyFive);
        ivTwentyFive.setImageDrawable(drawableTwentyFive);
    }

    public void getY() {
        ivOneY = ivOne.getY();
        ivTwoY = ivTwo.getY();
        ivThreeY = ivThree.getY();
        ivFourY = ivFour.getY();
        ivFiveY = ivFive.getY();
        ivSixY = ivSix.getY();
        ivSevenY = ivSeven.getY();
        ivEightY = ivEight.getY();
        ivNineY = ivNine.getY();
        ivTenY = ivTen.getY();
        ivElevenY = ivEleven.getY();
        ivTwelveY = ivTwelve.getY();
        ivThirteenY = ivThirteen.getY();
        ivFourteenY = ivFourteen.getY();
        ivFifteenY = ivFifteen.getY();
        ivSixteenY = ivSixteen.getY();
        ivSeventeenY = ivSeventeen.getY();
        ivEighteenY = ivEighteen.getY();
        ivNineteenY = ivNineteen.getY();
        ivTwentyY = ivTwenty.getY();
        ivTwentyOneY = ivTwentyOne.getY();
        ivTwentyTwoY = ivTwentyTwo.getY();
        ivTwentyThreeY = ivTwentyThree.getY();
        ivTwentyFourY = ivTwentyFour.getY();
        ivTwentyFiveY = ivTwentyFive.getY();

        ivOneX = ivOne.getX();
        ivTwoX = ivTwo.getX();
        ivThreeX = ivThree.getX();
        ivFourX = ivFour.getX();
        ivFiveX = ivFive.getX();
        ivSixX = ivSix.getX();
        ivSevenX = ivSeven.getX();
        ivEightX = ivEight.getX();
        ivNineX = ivNine.getX();
        ivTenX = ivTen.getX();
        ivElevenX = ivEleven.getX();
        ivTwelveX = ivTwelve.getX();
        ivThirteenX = ivThirteen.getX();
        ivFourteenX = ivFourteen.getX();
        ivFifteenX = ivFifteen.getX();
        ivSixteenX = ivSixteen.getX();
        ivSeventeenX = ivSeventeen.getX();
        ivEighteenX = ivEighteen.getX();
        ivNineteenX = ivNineteen.getX();
        ivTwentyX = ivTwenty.getX();
        ivTwentyOneX = ivTwentyOne.getX();
        ivTwentyTwoX = ivTwentyTwo.getX();
        ivTwentyThreeX = ivTwentyThree.getX();
        ivTwentyFourX = ivTwentyFour.getX();
        ivTwentyFiveX = ivTwentyFive.getX();

    }

    public void setVisibility() {
        ivOne.setVisibility(View.VISIBLE);
        ivTwo.setVisibility(View.VISIBLE);
        ivThree.setVisibility(View.VISIBLE);
        ivFour.setVisibility(View.VISIBLE);
        ivFive.setVisibility(View.VISIBLE);
        ivSix.setVisibility(View.VISIBLE);
        ivSeven.setVisibility(View.VISIBLE);
        ivEight.setVisibility(View.VISIBLE);
        ivNine.setVisibility(View.VISIBLE);
        ivTen.setVisibility(View.VISIBLE);
        ivEleven.setVisibility(View.VISIBLE);
        ivTwelve.setVisibility(View.VISIBLE);
        ivThirteen.setVisibility(View.VISIBLE);
        ivFourteen.setVisibility(View.VISIBLE);
        ivFifteen.setVisibility(View.VISIBLE);
        ivSixteen.setVisibility(View.VISIBLE);
        ivSeventeen.setVisibility(View.VISIBLE);
        ivEighteen.setVisibility(View.VISIBLE);

        ivNineteen.setVisibility(View.VISIBLE);
        ivTwenty.setVisibility(View.VISIBLE);
        ivTwentyOne.setVisibility(View.VISIBLE);
        ivTwentyTwo.setVisibility(View.VISIBLE);
        ivTwentyThree.setVisibility(View.VISIBLE);
        ivTwentyFour.setVisibility(View.VISIBLE);
        ivTwentyFive.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        pauseTimer();
    }
}