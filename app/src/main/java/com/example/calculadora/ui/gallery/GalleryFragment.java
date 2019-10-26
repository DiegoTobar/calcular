package com.example.calculadora.ui.gallery;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.calculadora.R;
import com.fathzer.soft.javaluator.DoubleEvaluator;

public class GalleryFragment extends Fragment implements  View.OnClickListener{

    private GalleryViewModel galleryViewModel;
    private TextView display;
    private EditText historial;
    String total="";
    SharedPreferences prefe;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bmas,bmen,bmul,bdiv,bpun,bigual,bdel, bac,bacerca,bder,bizq;
    Button bsen,bcos,btan,bln,bsqr,bporcentaje,babs,b1x,bfactorial;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }

        });


            b0 = root.findViewById(R.id.btn_0);
            b0.setOnClickListener(this);
            b1 = root.findViewById(R.id.btn_1);
            b1.setOnClickListener(this);
            b2 = root.findViewById(R.id.btn2);
            b2.setOnClickListener(this);
            b3 = root.findViewById(R.id.btn3);
            b3.setOnClickListener(this);
            b4 = root.findViewById(R.id.btn4);
            b4.setOnClickListener(this);
            b5 = root.findViewById(R.id.btn5);
            b5.setOnClickListener(this);
            b6 = root.findViewById(R.id.btn6);
            b6.setOnClickListener(this);
            b7 = root.findViewById(R.id.btn7);
            b7.setOnClickListener(this);
            b8 = root.findViewById(R.id.btn8);
            b8.setOnClickListener(this);
            b9 = root.findViewById(R.id.btn9);
            b9.setOnClickListener(this);
            bmas = root.findViewById(R.id.btn_mas);
            bmas.setOnClickListener(this);
            bmen = root.findViewById(R.id.btn_menos);
            bmen.setOnClickListener(this);
            bmul = root.findViewById(R.id.btn_por);
            bmul.setOnClickListener(this);
            bdiv = root.findViewById(R.id.btn_div);
            bdiv.setOnClickListener(this);
            bpun = root.findViewById(R.id.btnpunto);
            bpun.setOnClickListener(this);
            bigual = root.findViewById(R.id.btnigual);
            bigual.setOnClickListener(this);
            bdel = root.findViewById(R.id.btndel);
            bdel.setOnClickListener(this);
            bac = root.findViewById(R.id.btnac);
            bac.setOnClickListener(this);
            bacerca = root.findViewById(R.id.btndel);
            bacerca.setOnClickListener(this);
            bder = root.findViewById(R.id.btn_der);
            bder.setOnClickListener(this);
            bizq = root.findViewById(R.id.btn_izq);
            bizq.setOnClickListener(this);

        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE) {


            bsen = root.findViewById(R.id.btnsen);
            bsen.setOnClickListener(this);
            bcos = root.findViewById(R.id.btncos);
            bcos.setOnClickListener(this);
            btan = root.findViewById(R.id.btntan);
            btan.setOnClickListener(this);
            bln = root.findViewById(R.id.btnln);
            bln.setOnClickListener(this);
            bsqr = root.findViewById(R.id.btnsqr);
            bsqr.setOnClickListener(this);
            babs = root.findViewById(R.id.btn_x);
            babs.setOnClickListener(this);
            bporcentaje = root.findViewById(R.id.bporcentaje);
            bporcentaje.setOnClickListener(this);
            b1x = root.findViewById(R.id.boton_uno_x);
            b1x.setOnClickListener(this);
            bfactorial = root.findViewById(R.id.bfactorial);
            bfactorial.setOnClickListener(this);



        }
        display = root.findViewById(R.id.display);
        return root;
    }

  @Override
    public void onClick(View v) {
        String cadena = display.getText().toString();

        String cadenavacia="";
        String resultString="";
        char igual= '0';
            switch (v.getId()) {
                case R.id.btn_0:
                    cadena = cadena+'0' ;
                    break;
                case R.id.btn_1:
                    cadena = cadena + '1';
                    break;
                case R.id.btn2:
                    cadena = cadena + '2';
                    break;
                case R.id.btn3:
                    cadena = cadena + '3';
                    break;
                case R.id.btn4:
                    cadena = cadena + '4';
                    break;

                case R.id.btn5:
                    cadena = cadena + '5';
                    break;

                case R.id.btn6:
                    cadena = cadena + '6';
                    break;

                case R.id.btn7:
                    cadena = cadena + '7';
                    break;
                case R.id.btn8:
                    cadena = cadena + '8';
                    break;
                case R.id.btn9:
                    cadena = cadena + '9';
                    break;

                case R.id.btn_mas:
                    cadena = cadena + '+';
                    break;

                case R.id.btn_menos:
                    cadena = cadena + '-';
                    break;

                case R.id.btn_por:
                    cadena = cadena + '*';
                    break;

                case R.id.btn_div:
                    cadena = cadena + '/';
                    break;

                case R.id.btnigual:
                    Double result = new DoubleEvaluator().evaluate(cadena);

                    resultString = String.valueOf(result);


                    prefe=this.getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
                    total=prefe.getString("operaciones", "");
                    SharedPreferences.Editor editor=prefe.edit();
                    total=total+display.getText()+"="+resultString+"\n";
                    editor.putString("operaciones", total);
                    editor.apply();
                    igual='1';
                    break;

                case R.id.btnpunto:
                    if(cadena.length()==0)
                        cadena = cadena + "0.";
                    else
                        cadena = cadena + '.';
                    break;


                case R.id.btndel:
                    if(cadena.length() != 0)
                        cadena = cadena.substring(0, cadena.length() - 1);
                    break;
                case R.id.btnac:
                    cadena = cadenavacia;
                    break;

                case R.id.btn_der:
                    if(cadena.length()==0)
                        cadena = cadena;
                    else
                        cadena=cadena+')';
                    break;
                case R.id.btn_izq:
                    cadena=cadena+'(';
                    break;
                case R.id.btnsen:
                    cadena=cadena+ "sen(";
                    break;
                case R.id.btncos:
                    cadena=cadena+ "cos(";
                    break;
                case R.id.btntan:
                    cadena=cadena+ "tan(";
                    break;
                case R.id.bporcentaje:
                    cadena=cadena+ "%";
                    break;

                case R.id.bfactorial:
                    cadena=cadena+ "!";
                    break;
                case R.id.boton_uno_x:
                    cadena= "1/"+cadena;
                    break;
                case R.id.btn_x:
                    cadena=cadena+ "*abs(";
                    break;
        }
        if(igual=='1') {
             display.setText(resultString);
            }
        else
            display.setText(cadena);

    }
}