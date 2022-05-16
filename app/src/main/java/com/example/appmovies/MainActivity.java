package com.example.appmovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.appmovies.adapter.BannerMoviesPagerAdapter;
import com.example.appmovies.adapter.MainRecyclerAdapter;
import com.example.appmovies.model.AllCategory;
import com.example.appmovies.model.BannerMovies;
import com.example.appmovies.model.CategoryItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
{
    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout Indicatortab, categoryTab;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> homeMoviesList;
    List<BannerMovies> actionsMoviesList;
    List<BannerMovies> funnyMoviesList;
    List<BannerMovies> kidsMoviesList;
    Timer sliderTimer;
    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycler;
    List<AllCategory> allCategoryList;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Indicatortab= findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tabLayout);

        homeMoviesList = new ArrayList<>();
        homeMoviesList.add(new BannerMovies(1,"The Expendables ","https://kenh14cdn.com/thumb_w/650/2016/1-1482533510374.jpg",""));
        homeMoviesList.add(new BannerMovies(2,"SHAZAM","https://storage.googleapis.com/stc.zcdn.link/hdf/c/33/1738228364875672333/1573054227767-poster-org-shazam-2019_poster.jpg",""));
        homeMoviesList.add(new BannerMovies(3,"Sonic","https://i.ytimg.com/vi/igPynWHHXyA/maxresdefault.jpg",""));
        homeMoviesList.add(new BannerMovies(4,"Doctoc Strange- Đa vũ trụ nổi loạn","https://www.cgv.vn/media/catalog/product/cache/1/image/1800x/71252117777b696995f01934522c402d/d/r/dr-strange-payoff-poster_1_.jpg",""));
        homeMoviesList.add(new BannerMovies(5,"Siêu Sao Siêu Ngố","https://giaithuongtinhnguyen.vn/review-phim-sieu-sao-sieu-ngo/imager_23918.jpg",""));

        actionsMoviesList = new ArrayList<>();

        actionsMoviesList.add(new BannerMovies(1,"The TranSportTer","https://lamhoangmedia.com/wp-content/uploads/2021/04/maxresdefault.jpg",""));
        actionsMoviesList.add(new BannerMovies(2,"ANGEL HAS FALLEN ","https://boxofficevietnam.com/wp-content/uploads/2019/08/nh%C3%A0-tr%E1%BA%AFng-th%E1%BA%A5t-th%E1%BB%A7.jpg",""));
        actionsMoviesList.add(new BannerMovies(3,"Spider-Man No Way Home ","https://m.media-amazon.com/images/M/MV5BZWMyYzFjYTYtNTRjYi00OGExLWE2YzgtOGRmYjAxZTU3NzBiXkEyXkFqcGdeQXVyMzQ0MzA0NTM@.jpg",""));
        actionsMoviesList.add(new BannerMovies(4,"Iron Man 3 ","https://i-giaitri.vnecdn.net/2013/03/03/caged-heat-CAGED-Payoff-UK-rgb-jpg-1362273802_m_460x0.jpg",""));
        actionsMoviesList.add(new BannerMovies(5,"Captain America 2 ","https://upload.wikimedia.org/wikipedia/vi/e/e8/Captain_America_The_Winter_Soldier.jpg",""));

        funnyMoviesList = new ArrayList<>();
        funnyMoviesList.add(new BannerMovies(1,"Rush Hour","http://biphim.co/public/files/flim/120x160/1463448197_MV5BMjAyMzAyNzY5N15BMl5BanBnXkFtZTcwNjU3MTc0MQ@@._V1_SX640_SY720_.jpg",""));
        funnyMoviesList.add(new BannerMovies(2,"Jumanji","http://khenphim.com/wp-content/uploads/2017/12/Jumanji-1.jpg",""));
        funnyMoviesList.add(new BannerMovies(3,"Trạng Quỳnh","https://channel.mediacdn.vn/thumb_w/640/2019/1/28/photo-1-1548650780609225459297.jpg",""));
        funnyMoviesList.add(new BannerMovies(4,"Siêu Sao Siêu Ngố","https://giaithuongtinhnguyen.vn/review-phim-sieu-sao-sieu-ngo/imager_23918.jpg",""));
        funnyMoviesList.add(new BannerMovies(5,"Cua Lại Vợ Bầu","https://i.ytimg.com/vi/l8vTMxuvz6Y/maxresdefault.jpg",""));

        kidsMoviesList = new ArrayList<>();
        kidsMoviesList.add(new BannerMovies(1,"Kungfu Panda 3","https://znews-photo.zingcdn.me/w660/Uploaded/xbhunku/2016_03_11/Poster_KungfuPanda_longtieng_campB1.jpg",""));
        kidsMoviesList.add(new BannerMovies(2,"Đẳng cấp thú cưng 2","http://thegioibluray.com/resources/200ceb26807d6bf99fd6f4f0d1ca54d4/1%202D25G/B4140N.JPG",""));
        kidsMoviesList.add(new BannerMovies(3,"SHAZAM","https://storage.googleapis.com/stc.zcdn.link/hdf/c/33/1738228364875672333/1573054227767-poster-org-shazam-2019_poster.jpg",""));
        kidsMoviesList.add(new BannerMovies(4,"Zootopia","https://static.wikia.nocookie.net/disney/images/2/2f/Zootopia_Poster.jpg/revision/latest?cb=20180923055534&path-prefix=vi",""));
        kidsMoviesList.add(new BannerMovies(5,"Hotel Transylvania","https://static2.vieon.vn/vieplay-image/carousel_web_v4/2021/07/07/c3v8pv0o_1920x1080-khachsanhuyenbi1_1920_1080.jpg",""));
        // this is default tab selected
        setBannerMoviesPagerAdapter(homeMoviesList);
        //on tab change selected data
        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition())
                {
                    case 1:
                        setBannerMoviesPagerAdapter(actionsMoviesList);
                        return;
                    case 2:
                        setBannerMoviesPagerAdapter(funnyMoviesList);
                        return;
                    case 3:
                        setBannerMoviesPagerAdapter(kidsMoviesList);
                        return;
                    default:
                        setBannerMoviesPagerAdapter(homeMoviesList);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        List<CategoryItem> homeCatListItem1 = new ArrayList<>();
        homeCatListItem1.add(new CategoryItem(1, "Ma cà rồng","https://image.tmdb.org/t/p/w342/h4WLN3cmEjCsH1fNGRfvGV6IPBX.jpg",""));
        homeCatListItem1.add(new CategoryItem(2, "Chiến binh phương bắc","https://image.tmdb.org/t/p/w342/zhLKlUaF1SEpO58ppHIAyENkwgw.jpg",""));
        homeCatListItem1.add(new CategoryItem(3, "Sinh vật huyền bí: Những bí mật","https://image.tmdb.org/t/p/w342/jrgifaYeUtTnaH7NF5Drkgjg2MB.jpg",""));
        homeCatListItem1.add(new CategoryItem(4, "Thành phố mất tích","https://image.tmdb.org/t/p/w342/neMZH82Stu91d3iqvLdNQfqPPyl.jpg",""));
        homeCatListItem1.add(new CategoryItem(5, "Nhím Sonic 2","https://image.tmdb.org/t/p/w342/6DrHO1jr3qVrViUO6s6kFiAGM7.jpg",""));

        List<CategoryItem> homeCatListItem2 = new ArrayList<>();
        homeCatListItem2.add(new CategoryItem(1, "Knights of Sidonia: Love Woven in the Stars","https://image.tmdb.org/t/p/w342/pFLTKXZLvG6mvZEZEUqNYiXBL09.jpg",""));
        homeCatListItem2.add(new CategoryItem(2, "Nhiệm vụ khó khăn","https://image.tmdb.org/t/p/w342/wMszdTo0UuGcAEEDHsQL9dmwLIG.jpg",""));
        homeCatListItem2.add(new CategoryItem(3, "Những kẻ bị nguyền rủa","https://image.tmdb.org/t/p/w342/rYobaxr1JHhmOSszqQh5Aj4Viiu.jpg",""));
        homeCatListItem2.add(new CategoryItem(4, "Người khởi lửa","https://image.tmdb.org/t/p/w342/2MTGip0nfahQ1jPQCZSfCsPBZes.jpg",""));
        homeCatListItem2.add(new CategoryItem(5, "Điểm bước ngoặt","https://image.tmdb.org/t/p/w342/ge7URX8RFL4zAiJ76dprYqs3HEt.jpg",""));

        List<CategoryItem> homeCatListItem3 = new ArrayList<>();
        homeCatListItem3.add(new CategoryItem(1, "Công tố viên chuyển sinh","https://image.tmdb.org/t/p/w342/6QDWvFl9eScywwF8eUvhVZBleb1.jpg",""));
        homeCatListItem3.add(new CategoryItem(2, "Nhật ký tự do của tôi","https://image.tmdb.org/t/p/w342/olmfFeKZyQoTwj9Zo3Y5IUaioPB.jpg",""));
        homeCatListItem3.add(new CategoryItem(3, "Blues nơi đảo xanh","https://image.tmdb.org/t/p/w342/sT5Mlt5UmKiGfBisccwmD4LnPRD.jpg",""));
        homeCatListItem3.add(new CategoryItem(4, "SPY x FAMILY","https://image.tmdb.org/t/p/w342/3r4LYFuXrg3G8fepysr4xSLWnQL.jpg",""));
        homeCatListItem3.add(new CategoryItem(5, "Hội những bà mẹ xanh","https://image.tmdb.org/t/p/w342/i67uBlKzy94FqzNJ8bai2IGJ6S.jpg",""));

        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1,"PHIM ĐỀ CỬ", homeCatListItem1));
        allCategoryList.add(new AllCategory(2,"PHIM LẺ MỚI CẬP NHẬT", homeCatListItem2));
        allCategoryList.add(new AllCategory(3,"PHIM BỘ MỚI CẬP NHẬT", homeCatListItem3));

        setMainRecycler(allCategoryList);
    }
    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList)
    {
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesPagerAdapter= new BannerMoviesPagerAdapter(this , bannerMoviesList );
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);
        Indicatortab.setupWithViewPager(bannerMoviesViewPager);
        Timer sliderTimer =  new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(),400,6000);
        Indicatortab.setupWithViewPager(bannerMoviesViewPager, true );

    }
    class AutoSlider extends TimerTask
    {

        @Override
        public void run()
        {
            MainActivity.this.runOnUiThread( new Runnable()
            {

                @Override
                public void run()
                {
                    if(bannerMoviesViewPager.getCurrentItem()< homeMoviesList.size()-1)
                    {
                        bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem()+1);
                    }
                    else
                    {
                        bannerMoviesViewPager.setCurrentItem(0);
                    }
                }
            });

        }
    }
    public void setMainRecycler(List<AllCategory> allCategoryList)
    {
        mainRecycler= findViewById(R.id.main_recy);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL, false);
        mainRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter= new MainRecyclerAdapter(this,allCategoryList);
        mainRecycler.setAdapter(mainRecyclerAdapter);
    }

}