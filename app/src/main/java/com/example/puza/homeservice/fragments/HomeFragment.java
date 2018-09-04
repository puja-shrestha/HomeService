package com.example.puza.homeservice.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.puza.homeservice.R;
import com.example.puza.homeservice.adapter.FeaturedServiceAdapter;
import com.example.puza.homeservice.adapter.PopularServiceAdapter;
import com.example.puza.homeservice.adapter.ServiceAdapter;
import com.example.puza.homeservice.adapter.TrendingServiceAdapter;
import com.example.puza.homeservice.model.FeaturedServiceItems;
import com.example.puza.homeservice.model.PopularServiceItems;
import com.example.puza.homeservice.model.ServiceItems;
import com.example.puza.homeservice.model.TrendingServiceItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends Fragment {

    Unbinder unbinder;

    @BindView(R.id.search)
    EditText search;

//    @BindView(R.id.imageview)
//    ImageView imageView;

    @BindView(R.id.textview_service)
    TextView textview_service;

//    @BindView(R.id.subtitle_one)
//    TextView subtitle_one;

    @BindView(R.id.textview_trending)
    TextView textview_trending;
//
//    @BindView(R.id.subtitle_two)
//    TextView subtitle_two;

    @BindView(R.id.see_all_one)
    TextView see_all_one;

    @BindView(R.id.see_all_two)
    TextView see_all_two;

    //slider
    private SliderLayout mDemoSlider;
    private LinearLayout mLinearLayout;

    /*---------------circle service items----------------------*/
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    ServiceAdapter adapter;
    List<ServiceItems> allItems;
    /*---------------------------------------------------*/

    /*---------------Trending items----------------------*/
    RecyclerView trendingRecyclerView;
    private RecyclerView.LayoutManager tLayoutManager;
    TrendingServiceAdapter trendingAdapter;
    List<TrendingServiceItems> trendingItems;
    /*---------------------------------------------------*/

    /*---------------Trending items----------------------*/
    RecyclerView popularRecyclerView;
    private RecyclerView.LayoutManager pLayoutManager;
    PopularServiceAdapter popularAdapter;
    List<PopularServiceItems> popularItems;
    /*---------------------------------------------------*/

    /*---------------featured items----------------------*/
    RecyclerView featuredRecyclerView;
    private RecyclerView.LayoutManager fLayoutManager;
    FeaturedServiceAdapter featuredAdapter;
    List<FeaturedServiceItems> featuredItems;
    /*---------------------------------------------------*/

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // bind view using butter knife
        unbinder = ButterKnife.bind(this, view);

        //hide the soft keyboard from inside a fragment
        getActivity().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //slider
        mDemoSlider = (SliderLayout)view.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.pagesContainer);
        setupSlider();

        /*-----------------------Circle image-------------------------------------*/
        recyclerView = (RecyclerView) view.findViewById(R.id.serviceRecyclerView);

        allItems = getAllItemList();

        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        adapter = new ServiceAdapter(getActivity(), allItems);
        recyclerView.setAdapter(adapter);
        /*------------------------------------------------------------*/

        /*------------------Trending Items--------------------------*/
        trendingRecyclerView = (RecyclerView) view.findViewById(R.id.trendingServiceRecyclerView);

        trendingItems = getTrendingServiceItem();

        trendingRecyclerView.setHasFixedSize(true);

        tLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        trendingRecyclerView.setLayoutManager(tLayoutManager);
        trendingAdapter = new TrendingServiceAdapter(getActivity(), trendingItems);
        trendingRecyclerView.setAdapter(trendingAdapter);

        /*------------------------------------------------------------*/

        /*------------------Popular Items--------------------------*/
       popularRecyclerView = (RecyclerView) view.findViewById(R.id.popularRecyclerView);

        popularItems = getPopularServiceItem();

        popularRecyclerView.setHasFixedSize(true);

        pLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        popularRecyclerView.setLayoutManager(pLayoutManager);
        popularAdapter = new PopularServiceAdapter(getActivity(), popularItems);
        popularRecyclerView.setAdapter(popularAdapter);

        /*------------------------------------------------------------*/

        /*------------------Featured Items--------------------------*/
        featuredRecyclerView = (RecyclerView) view.findViewById(R.id.featuredServiceRecyclerView);

        featuredItems = getFeaturedServiceItem();

        featuredRecyclerView.setHasFixedSize(true);

        fLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        featuredRecyclerView.setLayoutManager(fLayoutManager);
        featuredAdapter = new FeaturedServiceAdapter(getActivity(), featuredItems);
        featuredRecyclerView.setAdapter(featuredAdapter);

        /*------------------------------------------------------------*/

        return view;
    }


    private List<ServiceItems> getAllItemList() {
        allItems = new ArrayList<ServiceItems>();


        allItems.add(new ServiceItems(R.drawable.group138, "Plumber"));
        allItems.add(new ServiceItems(R.drawable.group136, "Washing"));
        allItems.add(new ServiceItems(R.drawable.group137, "Repair"));
        allItems.add(new ServiceItems(R.drawable.group135, "Plumber"));

        allItems.add(new ServiceItems(R.drawable.group138, "Washing"));
        allItems.add(new ServiceItems(R.drawable.group135, "Repair"));

        return allItems;
    }

    public List<TrendingServiceItems> getTrendingServiceItem(){
        trendingItems = new ArrayList<TrendingServiceItems>();

        trendingItems.add(new TrendingServiceItems(R.drawable.plumber2, "Home Wall Cleaning", "Starting from", "Rs 1000"));
        trendingItems.add(new TrendingServiceItems(R.drawable.repairing, "Home Wall Cleaning", "Starting from", "Rs 1000"));
        trendingItems.add(new TrendingServiceItems(R.drawable.plumber3, "Home Wall Cleaning", "Starting from", "Rs 1000"));
        trendingItems.add(new TrendingServiceItems(R.drawable.repair, "Home Wall Cleaning", "Starting from", "Rs 1000"));

        return trendingItems;
    }

    public List<PopularServiceItems>  getPopularServiceItem(){
        popularItems = new ArrayList<PopularServiceItems>();

        popularItems.add(new PopularServiceItems(R.drawable.plumber));
        popularItems.add(new PopularServiceItems(R.drawable.repair_mobile));
        popularItems.add(new PopularServiceItems(R.drawable.plumber1));
        popularItems.add(new PopularServiceItems(R.drawable.repairing));

        return popularItems;
    }

    private List<FeaturedServiceItems> getFeaturedServiceItem() {
        featuredItems = new ArrayList<FeaturedServiceItems>();

        featuredItems.add(new FeaturedServiceItems(R.drawable.plumber1, "Home Wall Cleaning"));
        featuredItems.add(new FeaturedServiceItems(R.drawable.repair_mobile, "Home Electrician"));
        featuredItems.add(new FeaturedServiceItems(R.drawable.repairing, "Dining Table Setup"));
        featuredItems.add(new FeaturedServiceItems(R.drawable.repair, "Repairing"));
        featuredItems.add(new FeaturedServiceItems(R.drawable.plumber, "Washing"));
        featuredItems.add(new FeaturedServiceItems(R.drawable.plumber3, "Home Painting"));

        return featuredItems;
    }

    //slider
    private void setupSlider() {
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Cleaning",R.drawable.repair_mobile);
        file_maps.put("Repair",R.drawable.plumber3);
        file_maps.put("Washing",R.drawable.repairing);
        file_maps.put("Plumber", R.drawable.plumber1);
        file_maps.put("Repair", R.drawable.plumber);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Top);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(1000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        // unbind the view to free some memory
        unbinder.unbind();
    }
}
