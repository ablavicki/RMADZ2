package com.ferit.ablavicki.rmadz2;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    static int value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        final Intent intent = new Intent(getIntent());
        value = intent.getIntExtra("value", -1);
        mViewPager.setCurrentItem(value);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        EditText etValue;
        EditText etResult;
        Button bResult;
        Spinner sFrom;
        Spinner sTo;

        public PlaceholderFragment() {
        }
        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            etResult = rootView.findViewById(R.id.etResult);
            etValue = rootView.findViewById(R.id.etValue);
            bResult = rootView.findViewById(R.id.bResult);

            bResult.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    conversionSetup();
                }
            });


            switch (getArguments().getInt(ARG_SECTION_NUMBER)){
                case 1:
                    setupSpinner(rootView, R.array.length_units);
                    break;
                case 2:
                    setupSpinner(rootView, R.array.speed_units);
                    break;
                case 3:
                    setupSpinner(rootView, R.array.temperature_units);
                    break;
                case 4:
                    setupSpinner(rootView, R.array.weight_units);
                    break;
            }
            return rootView;
        }

        public void setupSpinner(View view, int R_units){
            sFrom = view.findViewById(R.id.sFrom);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R_units, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sFrom.setAdapter(adapter);
            sTo = view.findViewById(R.id.sTo);
            sTo.setAdapter(adapter);
        }

        public void conversionSetup (){

            int convertFrom = sFrom.getSelectedItemPosition();
            int convertTo = sTo.getSelectedItemPosition();
            double valueInput = Double.parseDouble(etValue.getText().toString());
            double valueResult;
            switch(value){
                case 0: //length
                    valueResult = Conversions.convertLength(convertFrom, convertTo, valueInput);
                    etResult.setText(Double.toString(valueResult));
                    break;

                case 1: //speed
                    valueResult = Conversions.convertSpeed(convertFrom, convertTo, valueInput);
                    etResult.setText(Double.toString(valueResult));
                    break;

                case 2: //temperature
                    if(convertFrom == 0) {
                        valueResult = Conversions.fromCelsius(convertTo, valueInput);
                        etResult.setText(Double.toString(valueResult));
                    }
                    else if(convertFrom == 1) {
                        valueResult = Conversions.fromFahrenheit(convertTo, valueInput);
                        etResult.setText(Double.toString(valueResult));
                    }
                    else {
                        valueResult = Conversions.fromKelvin(convertTo, valueInput);
                        etResult.setText(Double.toString(valueResult));
                    }
                    break;

                case 3: //weight
                    valueResult = Conversions.convertWeight(convertFrom, convertTo, valueInput);
                    etResult.setText(Double.toString(valueResult));
                    break;
            }
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }
    }

}