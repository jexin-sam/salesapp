package com.fabricmonde.salesapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;

import android.view.View;

import com.fabricmonde.salesapp.customscrollview.ScrollViewWithListener;
import com.fabricmonde.salesapp.tracemodel.generalInfo;
import com.fabricmonde.salesapp.tracemodel.madewithInfo;
import com.fabricmonde.salesapp.tracemodel.productInfo;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ChooseActivity extends AppCompatActivity {

    CardView truetrace,alternativesupply,stories,pricecalculator,testresults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        truetrace = findViewById(R.id.truetrace);
        alternativesupply = findViewById(R.id.alternatesupply);
        stories = findViewById(R.id.stories);
        pricecalculator = findViewById(R.id.calculator);
        testresults= findViewById(R.id.testresults);


        ScrollViewWithListener scroll = findViewById(R.id.scroll);
        productInfo productinfo = new productInfo("KCA2PL132","Organic Cotton","45''","30s*30s","60*49","100","Plain","Bleach","227 days","19,600 meters","295 Rupees",65,75,85,95,100);
        productinfo.setpBleachingCertification("ABC");
        productinfo.setpSliverCertification("GOTS");
        productinfo.setpInspectionCertification("ABC");
        productinfo.setpSpinningCertification("KVIC");
        productinfo.setpWeavingCertification("IHB/KVIC");
        productinfo.setpWashingCertification("ABC");
        ArrayList<madewithInfo> madewithinfo = new ArrayList<>();
        madewithinfo.add(new madewithInfo("Organic Cotton","GOTS"));
        madewithinfo.add(new madewithInfo("Handspun yarns from Charaka","KVIC"));
        madewithinfo.add(new madewithInfo("Handwoven fabric from handloom","IHB/KVIC"));
        productinfo.setpMadeinInfoList(madewithinfo);
        ArrayList<generalInfo>  sliverprep = new ArrayList<>();
        sliverprep.add(new generalInfo("Cotton Connect","New Delhi"));
        sliverprep.add( new generalInfo("Kanda Textiles","Salem Tamil Nadu"));
        sliverprep.add(new generalInfo("Vernal Textiles","New Delhi"));
        sliverprep.add(new generalInfo("Anandi Enterprises","Tirupur"));
        sliverprep.add(new generalInfo("Biore","Madhya Pradesh"));
        productinfo.setpSliverprepList(sliverprep);
        ArrayList<generalInfo> spinning = new ArrayList<>();
        spinning.add(new generalInfo("Sarvoday Sewa Samiti","Gujarat"));
        spinning.add(new generalInfo("Bapu Nagar Samaj Sewa Sangh","Gujarath"));
        spinning.add(new generalInfo("Bhagyodaya Sewa Sangh","Gujarath"));
        spinning.add(new generalInfo("Mahatma Gandhi Sewa Ashram","Madhya Pradesh"));
        spinning.add(new generalInfo("Khadi Nekarara Sahakara Utpadaka Sangha","Karnataka"));
        spinning.add(new generalInfo("Dharwad Taluka Hebballi Kshetriya Seva Sangh","Karnataka"));
        spinning.add(new generalInfo("Khadi & Gramodyog sahakari utpadak Sangh","Karnataka"));
        spinning.add(new generalInfo("Magan Khadi","Maharashtra"));
        spinning.add(new generalInfo("Gandhigram","Tamil Nadu"));
        spinning.add(new generalInfo("KVIC Units","Karnataka or Gujarat "));
        productinfo.setpSpinningList(spinning);
        ArrayList<generalInfo> weaving = new ArrayList<>();
        weaving.add(new generalInfo("Sarvoday Sewa Samiti","Gujarat"));
        weaving.add(new generalInfo("Bapu Nagar Samaj Sewa Sangh","Gujarath"));
        weaving.add(new generalInfo("Bhagyodaya Sewa Sangh","Gujarath"));
        weaving.add(new generalInfo("Mahatma Gandhi Sewa Ashram","Madhya Pradesh"));
        weaving.add(new generalInfo("Khadi Nekarara Sahakara Utpadaka Sangha","Karnataka"));
        weaving.add(new generalInfo("Dharwad Taluka Hebballi Kshetriya Seva Sangh","Karnataka"));
        weaving.add(new generalInfo("Khadi & Gramodyog sahakari utpadak Sangh","Karnataka"));
        weaving.add(new generalInfo("Magan Khadi","Maharashtra"));
        weaving.add(new generalInfo("Gandhigram","Tamil Nadu"));
        weaving.add(new generalInfo("KVIC Units","Karnataka or Gujarat "));
        productinfo.setpWeavingList(weaving);
        ArrayList<generalInfo> washing = new ArrayList<>();
        washing.add(new generalInfo("Wash Hub","Bangalore"));
        washing.add(new generalInfo("All associated units with the weaver associations across India","Bangalore"));
        productinfo.setpWashingList(washing);
        ArrayList<generalInfo> bleaching = new ArrayList<>();
        bleaching.add(new generalInfo("ABC","America"));
        productinfo.setpBleachingList(bleaching);
        ArrayList<generalInfo> inspection = new ArrayList<>();
        inspection.add(new generalInfo("Fabric Monde Pvt Ltd","Bangalore"));
        productinfo.setpInspectionList(inspection);
        db.getReference().child("products").child("KCA2PL132").setValue(productinfo);
        truetrace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseActivity.this,TraceActivity.class);
                startActivity(intent);

            }
        });

        alternativesupply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseActivity.this,AlternativeActivity.class);
                startActivity(intent);

            }
        });

        stories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}
