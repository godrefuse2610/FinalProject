package com.example.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.myapplication.adapter.BannerMoviesPagerAdapter;
import com.example.myapplication.adapter.MovieAdapter;
import com.example.myapplication.adapter.MovieItemClickListener;
import com.example.myapplication.model.BannerMovies;
import com.example.myapplication.model.Movie;
import com.example.myapplication.model.VipNotification;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener {

    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout firstTab, secondTab;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> bannerMoviesList;
    List<Movie> moviesList;
    List<Movie> moviescomesoonList;
    RecyclerView MoviesRV;
    BottomNavigationView bottomNavigationView;
    ArrayList<Movie> movies;
    ImageButton button;
    Movie filmPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movies = new ArrayList<>();
        setContentView(R.layout.activity_main);
        MoviesRV = findViewById(R.id.Rv_movies);
        firstTab = findViewById(R.id.indicator);
        secondTab = findViewById(R.id.tabLayout);
        button = findViewById(R.id.imageButton2);
        button.setOnClickListener(v -> {
            Intent in = new Intent(MainActivity.this, MapsFragment.class);
            startActivity(in);
                });
        createNotificationChannel();

        bannerMoviesList = new ArrayList<>();
        bannerMoviesList.add(new BannerMovies(R.drawable.banner1));
        bannerMoviesList.add(new BannerMovies(R.drawable.banner2));
        bannerMoviesList.add(new BannerMovies(R.drawable.banner3));
        bannerMoviesList.add(new BannerMovies(R.drawable.banner4));

        setBannerMoviesPagerAdapter(bannerMoviesList);

        moviesList = new ArrayList<>();
        moviesList.add(new Movie("Black Adam", R.drawable.black_adam, R.drawable.bg_blackadam, "Jaume Collet-Serra", "Action", "C13 - NO CHILDREN UNDER 13 YEARS OLD",  9.7f, "From New Line Cinema, Dwayne Johnson stars in the action adventure “Black Adam.” The first-ever feature film to explore the story of the DC Super Hero comes to the big screen under the direction of Jaume Collet-Serra (“Jungle Cruise”). Nearly 5,000 years after he was bestowed with the almighty powers of the ancient gods—and imprisoned just as quickly—Black Adam (Johnson) is freed from his earthly tomb, ready to unleash his unique form of justice on the modern world."));
        moviesList.add(new Movie("The Evil Eye (Mal de Ojo)", R.drawable.curse, R.drawable.bg_evileye, "Isaac Ezban", "Horror", "C18 - NO CHILDREN UNDER 18 YEARS OLD", 8.8f, "Nala, a 13-year-old girl from the city, travels with her family to her grandmother´s home in the countryside, to try to find a cure for her little sister´s mysterious illness… But she´ll soon find her granny is not exactly what she seems…"));
        moviesList.add(new Movie("Girl From The Past", R.drawable.girlpass, R.drawable.bg_girl,  "Bảo Nhân & Namcito", "Drama, Mystery, Thriller", "C18 - NO CHILDREN UNDER 18 YEARS OLD", 8.0f, "When a famous celebrity with a dark past meets an old friend from 15 years ago, secrets start to come back from the grave…"));
        moviesList.add(new Movie("Gulliver Returns", R.drawable.gulliver, R.drawable.bg_gulliver,  "Ilya Maksimov", "Animation", " P - GENERAL MOVIE TO ALL CUSTOMERS", 7.5f, "The legendary Gulliver returns to the Kingdom of Lilliput, but he is not the giant they remember."));



        moviescomesoonList = new ArrayList<>();
        moviescomesoonList.add(new Movie("Harry Potter And The Goblet Of Fire (Re-Run)", R.drawable.harrypotter, R.drawable.bg_potter, "Mike Newell", "Adventure, Fantasy", "P - GENERAL MOVIE TO ALL CUSTOMERS",9.2f, "The fourth movie in the Harry Potter franchise sees Harry (Daniel Radcliffe) returning for his fourth year at Hogwarts School of Witchcraft and Wizardry, along with his friends, Ron (Rupert Grint) and Hermione (Emma Watson). There is an upcoming tournament between the three major schools of magic, with one participant selected from each school by the Goblet of Fire. When Harry's name is drawn, even though he is not eligible and is a fourth player, he must compete in the dangerous contest."));
        moviescomesoonList.add(new Movie("Lyle Crocodile", R.drawable.lyle, R.drawable.bg_lyle, "Will Speck, Josh Gordon", "Animation", "P - GENERAL MOVIE TO ALL CUSTOMERS",7.9f, "Based on the best-selling book series by Bernard Waber, Lyle, Lyle, Crocodile is a live-action / CGI musical comedy that brings this beloved character to a new, global audience. When the Primm family (Constance Wu, Scoot McNairy, Winslow Fegley) moves to New York City, their young son Josh struggles to adapt to his new school and new friends. All of that changes when he discovers Lyle - a singing crocodile (Shawn Mendes) who loves baths, caviar and great music-living in the attic of his new home. The two become fast friends, but when Lyle’s existence is threatened by evil neighbor Mr. Grumps (Brett Gelman), the Primm’s must band together with Lyle’s charismatic owner, Hector P. Valenti (Javier Bardem), to show the world that family can come from the most unexpected places and there’s nothing wrong with a big singing crocodile with an even bigger personality. Lyle, Lyle, Crocodile will feature original songs performed by Shawn Mendes and written by the songwriting team behind The Greatest Showman, Benj Pasek & Justin Paul."));
        moviescomesoonList.add(new Movie("Black Panther: Wakanda Forever", R.drawable.wakanda, R.drawable.bg_wakanda, "Ryan Coogler", "Action, Adventure, Drama", "C13 - NO CHILDREN UNDER 13 YEARS OLD",8.8f, "Queen Ramonda (Angela Bassett), Shuri (Letitia Wright), M’Baku (Winston Duke), Okoye (Danai Gurira) and the Dora Milaje (including Florence Kasumba), fight to protect their nation from intervening world powers in the wake of King T’Challa’s death. As the Wakandans strive to embrace their next chapter, the heroes must band together with the help of War Dog Nakia (Lupita Nyong’o) and Everett Ross (Martin Freeman) and forge a new path for the kingdom of Wakanda."));
        moviescomesoonList.add(new Movie("One Piece Film Red", R.drawable.onepiece, R.drawable.bg_op, "Gorō Taniguchi", "Animation", "C13 - NO CHILDREN UNDER 13 YEARS OLD", 8.2f, "Uta —the most beloved singer in the world. Her voice, which she sings with while concealing her true identity, has been described as “otherworldly.” She will appear in public for the first time at a live concert. As the venue fills with all kinds of Uta fans —excited pirates, the Navy watching closely, and the Straw Hats led by Luffy who simply came to enjoy her sonorous performance —the voice that the whole world has been waiting for is about to resound. The story begins with the shocking fact that she is Shanks' daughter."));

        moviesList.sort((a, b) -> Float.compare(b.getRating(), a.getRating()));
        moviescomesoonList.sort((a, b) -> Float.compare(b.getRating(), a.getRating()));

        setMoviesPagerAdapter(moviesList);
        secondTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 1) {
                    setMoviesPagerAdapter(moviescomesoonList);
                }
                else {
                    setMoviesPagerAdapter(moviesList);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.navigation_home:

                    break;
                case R.id.navigation_fav:
                    Intent intent = new Intent(MainActivity.this, FavListActivity.class);
                    intent.putExtra("FavList",movies);
                    startActivity(intent);
                    break;
            }
            return true;
        });
    }
    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Vip";
            String description = "Pro";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("123", name, importance);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList){
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this, bannerMoviesList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);
        firstTab.setupWithViewPager(bannerMoviesViewPager);
    }
    private void setMoviesPagerAdapter(List<Movie> listMovies){
        MovieAdapter movieAdapter = new MovieAdapter(this,listMovies,this);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
        Intent intent = new Intent(this, MovieDetailActivity.class);
        filmPos = movie;
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("imgUrl", movie.getThumbnail());
        intent.putExtra("imgCover", movie.getCoverPhoto());
        intent.putExtra("director", movie.getDirector());
        intent.putExtra("type", movie.getType());
        intent.putExtra("rated", movie.getRated());
        intent.putExtra("description", movie.getDescription());

//        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, movieImageView, "sharedName");
        someActivityResultLauncher.launch(intent);
    }
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            (result) -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent intent = result.getData();
                    boolean isFavor = false;
                    Log.d("fdhdhfjy", ": "+filmPos);
                    if (intent!=null)
                        isFavor = intent.getBooleanExtra("favor",false);
                    if (isFavor){
                        movies.add(filmPos);
                    }else {
                        movies.remove(filmPos);
                    }

                }
            });
}