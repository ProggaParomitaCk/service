package com.example.signuploginfirebase;

import static com.example.signuploginfirebase.R.id.buttonBack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[] [] doctor_detaisl1 =
            {
                    {"Doctor Name : Md.Mumennuzaman", "Hospital Address :Akhalia", "Experience : 5yrs", "Mobile No: 01316677889", "Fees : 600"},
                    {"Doctor Name : Syed Ali", "Hospital Address : Rikabibazar", "Experience : 10yrs", "Mobile No: 01716777555","Fees : 600"},
                    {"Doctor Name : Md.Rahim", "Hospital Address : Madhushahid", "Experience : 4yrs", "Mobile No: 01816077659","Fees : 600"},
                    {"Doctor Name : Nurul Huda", "Hospital Address : Subhanighat", "Experience : 5yrs", "Mobile No: 01910077550","Fees : 600"},
                    {"Doctor Name : P.C Das", "Hospital Address : Subhanighat", "Experience : 5yrs", "Mobile No: 01723098765","Fees : 600"}
            };
    private String[] [] doctor_detaisl2 =
            {
                    {"Doctor Name : Ali noor", "Hospital Address :Ambarkhana", "Experience : 5yrs", "Mobile No: 01316677889", "Fees : 600"},
                    {"Doctor Name : Tripti Sinha", "Hospital Address : Rikabibazar", "Experience : 5yrs", "Mobile No: 01716777555","Fees : 600"},
                    {"Doctor Name : Ruhana Khanom", "Hospital Address : Madhushahid", "Experience : 4yrs", "Mobile No: 01816077659","Fees : 600"},
                    {"Doctor Name : Aminul Islam", "Hospital Address : Subhanighat", "Experience : 5yrs", "Mobile No: 01910077550","Fees : 600"},
                    {"Doctor Name : Anisul Sikdar", "Hospital Address : Subhanighat", "Experience : 5yrs", "Mobile No: 01723098765","Fees : 600"}
            };
    private String[] [] doctor_detaisl3 =
            {
                    {"Doctor Name : Sadia Haque", "Hospital Address :Akhalia", "Experience : 5yrs", "Mobile No: 01316677889", "Fees : 600"},
                    {"Doctor Name : Ragib Ahmed", "Hospital Address : Rikabibazar", "Experience : 10yrs", "Mobile No: 01716777555","Fees : 600"},
                    {"Doctor Name : Pandit Sarkar", "Hospital Address : Madhushahid", "Experience : 4yrs", "Mobile No: 01816077659","Fees : 600"},
                    {"Doctor Name : Nurul Huda", "Hospital Address : Subhanighat", "Experience : 5yrs", "Mobile No: 01910077550","Fees : 600"},
                    {"Doctor Name : Avrodeep Das", "Hospital Address : Subhanighat", "Experience : 5yrs", "Mobile No: 01723098765","Fees : 600"}
            };
    private String[] [] doctor_detaisl4 =
            {
                    {"Doctor Name : Md. Liaquat Ali", "Hospital Address :Akhalia", "Experience : 5yrs", "Mobile No: 01316677889", "Fees : 600"},
                    {"Doctor Name : Golum Haider Ali", "Hospital Address : Rikabibazar", "Experience : 10yrs", "Mobile No: 01716777555","Fees : 600"},
                    {"Doctor Name : Sajal Krishna", "Hospital Address : Madhushahid", "Experience : 4yrs", "Mobile No: 01816077659","Fees : 600"},
                    {"Doctor Name : M.A Bashar", "Hospital Address : Subhanighat", "Experience : 5yrs", "Mobile No: 01910077550","Fees : 600"},
                    {"Doctor Name : Abu Zafar", "Hospital Address : Subhanighat", "Experience : 5yrs", "Mobile No: 01723098765","Fees : 600"}
            };
    private String[] [] doctor_detaisl5 =
            {
                    {"Doctor Name : Amal Kumar Chowdhury", "Hospital Address :Akhalia", "Experience : 5yrs", "Mobile No: 01316677889", "Fees : 600"},
                    {"Doctor Name : Mamunnur Rashid", "Hospital Address : Rikabibazar", "Experience : 10yrs", "Mobile No: 01716777555","Fees : 600"},
                    {"Doctor Name : Md.Karim", "Hospital Address : Madhushahid", "Experience : 4yrs", "Mobile No: 01816077659","Fees : 600"},
                    {"Doctor Name : Prasanta Kumar Chanda", "Hospital Address : Subhanighat", "Experience : 5yrs", "Mobile No: 01910077550","Fees : 600"},
                    {"Doctor Name : P.K Chandra", "Hospital Address : Subhanighat", "Experience : 5yrs", "Mobile No: 01723098765","Fees : 600"}
            };

    TextView tv;
    Button btn;
    String[][] doctor_detail = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDtitle);
        btn = findViewById(R.id.buttonBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("FAMILY PHYSICIAN")==0)
            doctor_detail = doctor_detaisl1;
        else
        if (title.compareTo("Dietician")==0)
            doctor_detail = doctor_detaisl2;
        else
        if (title.compareTo("Dentist")==0)
            doctor_detail = doctor_detaisl3;
        else
        if (title.compareTo("Surgeon")==0)
            doctor_detail = doctor_detaisl4;
        else
            doctor_detail = doctor_detaisl5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_detail.length;i++){

            item = new HashMap<String,String>();
            item.put("line1",doctor_detail[i][0]);
            item.put("line2",doctor_detail[i][1]);
            item.put("line3",doctor_detail[i][2]);
            item.put("line4",doctor_detail[i][3]);
            item.put("line5","Cons Fees:"+doctor_detail[i][4]+"/-");
            list.add(item);

        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}

                );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",doctor_detail[i][0]);
                it.putExtra("text2",doctor_detail[i][1]);
                it.putExtra("text3",doctor_detail[i][2]);
                it.putExtra("text4",doctor_detail[i][3]);
                it.putExtra("text5",doctor_detail[i][4]);
                startActivity(it);
            }
        });
    }
}