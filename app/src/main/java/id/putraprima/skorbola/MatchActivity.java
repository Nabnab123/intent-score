package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {

    private String hometeam;
    private String awayteam;
    private String winner;
    private int homescore;
    private int awayscore;
    private TextView scoreHome;
    private TextView scoreAway;
    private TextView homeText;
    private TextView awayText;
    private TextView eventText;
    private ImageView homeLogo;
    private ImageView awayLogo;
    private Button addHome1, addHome2, addHome3;
    private Button addAway1, addAway2, addAway3;
    private Button cekResult;
    private Uri winnerImage;
    private Uri homeLogoUri, awayLogoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        homeText = findViewById(R.id.txt_home);
        awayText = findViewById(R.id.txt_away);
        scoreHome = findViewById(R.id.score_home);
        scoreAway = findViewById(R.id.score_away);
        homeLogo = findViewById(R.id.home_logo);
        awayLogo = findViewById(R.id.away_logo);
        addHome1 = findViewById(R.id.btn_add_home1);
        addHome2 = findViewById(R.id.btn_add_home2);
        addHome3 = findViewById(R.id.btn_add_home3);
        addAway1 = findViewById(R.id.btn_add_away1);
        addAway2 = findViewById(R.id.btn_add_away2);
        addAway3 = findViewById(R.id.btn_add_away3);
        eventText = findViewById(R.id.event_text);
        cekResult = findViewById(R.id.btn_result);

        homescore = 0;
        awayscore = 0;
        scoreHome.setText(String.valueOf(homescore));
        scoreAway.setText(String.valueOf(awayscore));

        Bundle bundle = getIntent().getExtras();
        hometeam = bundle.getString("namahome");
        homeText.setText(hometeam);
        awayteam = bundle.getString("namaaway");
        awayText.setText(awayteam);
        homeLogoUri = Uri.parse(bundle.getString("homeImg"));
        awayLogoUri = Uri.parse(bundle.getString("awayImg"));
        homeLogo.setImageURI(homeLogoUri);
        awayLogo.setImageURI(awayLogoUri);

        addHome1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homescore += 1;
                scoreHome.setText(String.valueOf(homescore));
                eventText.setText(homeText.getText() + " score a point");
            }
        });

        addHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homescore += 2;
                scoreHome.setText(String.valueOf(homescore));
                eventText.setText(homeText.getText() + " score 2 points");
            }
        });

        addHome3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homescore += 3;
                scoreHome.setText(String.valueOf(homescore));
                eventText.setText(homeText.getText() + " score 3 points");
            }
        });

        addAway1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awayscore += 1;
                scoreAway.setText(String.valueOf(awayscore));
                eventText.setText(awayText.getText() + " score a point");
            }
        });

        addAway2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awayscore += 2;
                scoreAway.setText(String.valueOf(awayscore));
                eventText.setText(awayText.getText() + " score 2 points");
            }
        });

        addAway3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awayscore += 3;
                scoreAway.setText(String.valueOf(awayscore));
                eventText.setText(awayText.getText() + " score 3 points");
            }
        });

        cekResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                winner = "empty";
                if(homescore > awayscore){
                    winner = hometeam;
                    winnerImage = homeLogoUri;
                }
                else if (homescore == awayscore){
                    winner = "draw";
                    winnerImage = homeLogoUri;
                }
                else {
                    winner = awayteam;
                    winnerImage = awayLogoUri;
                }

                Intent intent = new Intent(MatchActivity.this, ResultActivity.class);
                intent.putExtra("winner", winner);
                intent.putExtra("winnerLogo", winnerImage.toString());
                startActivity(intent);
            }
        });


        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }
}