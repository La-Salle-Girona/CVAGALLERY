package com.example.galeria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;
import com.example.galeria.adapter.GalleryCVAdapter;
import android.widget.VideoView;
import android.net.Uri;
import android.widget.MediaController;


public class ImagenFullCVA extends AppCompatActivity {

    private VideoView videoView;

    ImageView imageView;
    TextView textDescripcion;
    GalleryCVAdapter galleryCVAdapter;

    String[] descripciones = {
            "Astra es una agente ghanesa de Valorant que usa su poder cósmico para controlar el campo de batalla con habilidades estratégicas y estelares. ✨\uD83D\uDE80",
            "Brimstone es un comandante veterano de Valorant que despliega poder aéreo con precisión, brindando apoyo táctico con humo, fuego y ataques orbitales. \uD83D\uDD25\uD83C\uDFAF",
            "Chamber es un letal agente francés en Valorant, un francotirador elegante que combina precisión, estilo y armamento personalizado para eliminar a sus enemigos. \uD83C\uDFAF\uD83C\uDCCF",
            "Clove es un agente astuto y rebelde en Valorant, con habilidades que le permiten burlar la muerte y manipular el combate a su favor. \uD83C\uDCCF\uD83D\uDC80",
            "Fade es una cazarrecompensas turca en Valorant, experta en el miedo y las pesadillas, que usa la oscuridad para revelar y atormentar a sus enemigos. \uD83C\uDF18\uD83D\uDC41\uFE0F",
            "Harbor es un agente indio en Valorant, un maestro del agua que usa tecnología ancestral para controlar el flujo del combate con escudos y olas defensivas. \uD83C\uDF0A\uD83D\uDEE1\uFE0F",
            "Iso es un cazarrecompensas chino en Valorant, un duelista imparable que manipula el combate con escudos de energía y un enfoque letal en los duelos individuales. ⚡\uD83C\uDFAF",
            "Jett es una agente de Valorant con habilidades de agilidad y movilidad excepcionales, especializada en el control del viento y en el movimiento rápido.",
            "Neon es una agente de Valorant con habilidades centradas en la velocidad y la electricidad, capaz de moverse rápidamente y lanzar poderosos ataques eléctricos.",
            "Omen es un controlador sigiloso en Valorant, especializado en el uso de habilidades de manipulación de sombras para desorientar y controlar el terreno de juego.",
            "Phoenix es un agente de Valorant con habilidades de fuego, capaz de curarse a sí mismo y crear zonas de daño, además de usar su habilidad \"Ultimate\" para resucitar tras morir.",
            "Raze es un agente de Valorant especializado en explosivos, con habilidades que incluyen granadas, un lanzacohetes y un satélite de explosivos para infligir grandes daños en áreas y desestabilizar al enemigo.",
            "Sage es un agente de Valorant que se especializa en la curación y el control del terreno, utilizando habilidades como barreras curativas, un muro de hielo y su habilidad \"Ultimate\" para resucitar a los compañeros caídos.",
            "Reyna es un agente de Valorant enfocada en la autosuficiencia, con habilidades que le permiten curarse, obtener invulnerabilidad temporal y potenciar su poder al eliminar enemigos, lo que la convierte en una amenaza letal.",
            "Cypher es un agente de Valorant especializado en la vigilancia y el control del mapa, utilizando trampas y cámaras para espiar y desorientar a los enemigos, permitiendo a su equipo obtener información clave sobre la ubicación del rival.",
            "Gekko es un agente de Valorant que usa criaturas y dispositivos para controlar el terreno y desorientar a los enemigos.",
            "Viper es un agente de Valorant que utiliza venenos y trampas químicas para controlar el área, infligiendo daño y cegando a los enemigos.",
            "La mente maestra del metal, Vyse, desata metal líquido para aislar, atrapar y desarmar a sus enemigos. Mediante astucia y manipulación, obliga a todos los que se le oponen a temer el propio campo de batalla.\n"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imagen_full_cva);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializa el VideoView
        videoView = findViewById(R.id.videoView);

        // Carga el video desde la carpeta raw
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.valorant); // 'video' es el nombre del archivo sin la extensión .mp4

        // Configura el VideoView con el video
        videoView.setVideoURI(videoUri);

        // Agrega un MediaController para controlar la reproducción
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        // Inicia la reproducción del video
        videoView.start();

        imageView = findViewById(R.id.imageView);
        textDescripcion = findViewById(R.id.textDescripcion);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Personaje");

        Intent intent=getIntent();
        int posicio = intent.getExtras().getInt("idImatge");

        galleryCVAdapter = new GalleryCVAdapter(this);
        imageView.setImageResource(galleryCVAdapter.imgArray[posicio]);

        // Mostrar la descripción correspondiente a la imagen
        if (posicio < descripciones.length) {
            textDescripcion.setText(descripciones[posicio]);
        } else {
            textDescripcion.setText("Sin descripción");
        }
    }
}