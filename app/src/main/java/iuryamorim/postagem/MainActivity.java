package iuryamorim.postagem;

import android.app.SearchManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import iuryamorim.postagem.adapter.ViewPagerAdapter;
import iuryamorim.postagem.domain.Artigo;
import iuryamorim.postagem.domain.Video;
import iuryamorim.postagem.fragments.FragmentArtigos;
import iuryamorim.postagem.fragments.FragmentVideos;

public class MainActivity extends AppCompatActivity {
    private List<Artigo> listArtigos;
    private List<Video> listVideos;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        viewPager = (ViewPager) findViewById(R.id.viewPager);
        configurarViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void configurarViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FragmentArtigos(), "Artigos");
        viewPagerAdapter.addFragment(new FragmentVideos(), "Vídeos");

        viewPager.setAdapter(viewPagerAdapter);
    }

    public static List<Artigo> getSetArtigoList(int qtd) {

        String[] tituloCardArtigo = new String[]{"Você é inteligente?", "Nhoc!", "Triângulo das Bermudas",
                "Incrível!", "Jacaré de estimação", "Coelhinho da páscoa", "6 mil fósforos",
                "Dormir por apenas 6 horas", "Caçadores de alienígenas", "Beijo"};
        String[] subTituloCardArtigo = new String[]{
                "Pesquisa revela sinal curioso de que alguém é realmente inteligente",
                "Quer saber como é ser atacado por um crocodilo?",
                "O mistério sobre o Triângulo das Bermudas foi finalmente solucionado?",
                "Fotógrafo edita imagens e transforma seu cão em um amigo gigante",
                "Americana briga na Justiça para não perder Rambo, seu jacaré de estimação",
                "Afinal, o que o coelhinho tem a ver com a Páscoa?",
                "Ver 6 mil fósforos queimando é mais divertido do que parece",
                "Sabia que dormir por apenas 6 horas equivale a passar noites em claro?",
                "Caçadores de alienígenas alegam possuir provas de que eles moram no Sol",
                "Por que beijamos de olhos fechados?"};
        String[] textoCardArtigo = new String[]{
                "Algumas pessoas não apenas gostam de passar um tempo sozinhas como sentem verdadeira necessidade disso. Não significa, é óbvio, que gostam pouco ou nada de seus amigos, colegas e familiares. Na verdade, para elas a solidão é uma espécie de exercício normal – e nada triste, que fique claro – que recarrega as energias.\n\nSe você é um desses amantes da solidão – ou se conhece alguém que seja – eis uma notícia interessante sobre eles: esse é um comportamento típico de pessoas extremamente inteligentes.\n\nA afirmação vem de uma pesquisa realizada pela London School of Economics e também pela Singapore Management University. Os pesquisadores analisaram dados de 15 mil pessoas – entre esses dados, estavam também os resultados de seus testes de Q.I.\n\nOs resultados não deixaram dúvidas: a maioria das pessoas fica feliz mesmo quando sua vida social está ativa; agora aquelas pessoas que tiveram as maiores notas de Q.I. foram as que disseram que ficam felizes e confortáveis mesmo quando estão sozinhas. Ou seja: da próxima vez que você visitar alguém muito inteligente, é possível que essa pessoa queira que você vá embora logo – cof cof.",
                "Você já assistiu a um desses documentários sobre animais selvagens no qual crocodilos famintos abocanham suas presas? E você já sentiu curiosidade — mórbida — em saber o que o bichinho atacado viu? Pois agora você poderá descobrir graças ao pessoal da National Geographic!\n\nAs imagens que você verá logo mais mostram ataques de crocodilos de água salgada, mas sob a perspectiva da presa, coitada. Segundo a National Geographic, o vídeo foi registrado pelo fotógrafo\n\n\n\nComo você acabou de ver no vídeo, Frost e Lesh montaram pequenos dispositivos controlados por controle remoto e equipados com câmeras, e atraíram crocodilos para o ataque com sucesso nove vezes. Por sorte, as imagens não mostram nenhum animal indefeso sendo devorado e, de acordo com a National Geographic, esta é a primeira vez que ataques desses répteis são registrados do ponto de vista dos bichos atacados.\n\nA coisa pode não ter parecido tão dramática assim para você, mas, tente se colocar no lugar da presa e lembre que os crocodilos de água salgada chegam a medir mais de seis metros de comprimento e pesar quase uma tonelada. Como se fosse pouco, esses monstrões têm a mordida mais poderosa entre os animais do planeta, com uma força entre 1,3 mil e 2,3 mil quilos por polegada quadrada — o que seria mais que suficiente para esmagar um crânio humano.\n\nAliás, tenha todas essas informações em mente caso você vá para a Austrália um dia e decida dar um mergulho por lá. Na década de 70, a estimativa era de que apenas 3 mil crocodilos de água salgada viviam por lá. No entanto, os cientistas acreditam que atualmente exista uma população de 100 mil deles só no Território do Norte e que eles somem cerca de 200 mil na região norte da Austrália.",
                "O mitológico Triângulo das Bermudas, como você sabe, é uma área situada no Atlântico Norte associada com o desaparecimento de diversas embarcações, aeronaves e pessoas. O local recebeu esse nome em meados da década de 60 graças à forma geométrica que obtemos quando traçamos linhas para conectar as cidades de Miami, nos EUA, San Juan, em Porto Rico, e Bermuda — que delimitam a região na qual os incidentes supostamente acontecem.\n\nO número de desaparecimentos na área é incerto e, dependendo da fonte consultada, ele gira em torno de 100 embarcações e aviões e cerca de mil pessoas nos últimos 100 anos. Contudo, vale lembrar que levantamentos feitos por uma das seguradoras mais importantes do mundo apontaram que não acontecem mais incidentes por ali do que em qualquer outro lugar do planeta, e a Guarda Costeira dos EUA não reconhece o Triângulo das Bermudas como perigoso.",
                "O fotógrafo Christopher Cline mudou de cidade e, obviamente, começou a sentir saudade de sua vida anterior. Vivendo agora em Minnesota, nos EUA, ele acabou ganhando Juji, um cachorro que sua namorada comprou para que ele pudesse se sentir menos solitário.\n\nNo início, Cline não ficou tão empolgado assim com a novidade, mas com o passar do tempo percebeu que Juji era um ótimo companheiro e, além disso, uma fonte de inspiração. Desde então, ele tem feito fotos ao lado de seu cão – mas tem um detalhe: Cline edita todas as imagens para que Juji fique gigante. O resultado? Simplesmente incrível. ",
                "A maioria das pessoas tem ou pelo menos já teve um animalzinho de estimação, e Mary Thorn, uma mulher que vive no estado da Flórida, nos EUA, não é diferente. Diferente mesmo é o bichinho que ela tem em casa: Rambo, um jacaré que faz parte da família há 11 anos.\n\nTudo ia bem na vida dos Thorn até que Rambo começou a ficar grande demais e um pouco assustador também – ou você acharia superlegal que sua vizinha tivesse um jacaré gigante do outro lado do muro?\n\nO fato é que o caso foi parar nos tribunais, e agora Mary está fazendo tudo o que pode para manter o animal, de quase 2 metros de comprimento, em casa, como sempre foi. De acordo com as leis da Flórida, no entanto, ela deveria morar em uma propriedade cujo terreno medisse pelo menos 10 mil m² para que tivesse autorização para manter um jacaré como animal de estimação.",
                "Como você deve saber, hoje a Páscoa é uma celebração cristã que comemora a ressurreição de Jesus. No entanto, durante as festividades existe um personagem que aparece por todos os lados, sendo o responsável por entregar ovos de chocolate para as criancinhas bem comportadas. Você já sabe de quem estamos falando, não é mesmo?\n\nMas, afinal, o que o coelhinho tem a ver com a Páscoa, se nem ovos esses animais botam? Bem, na verdade, o surgimento desse simpático personagem tem relação com o paganismo. No Hemisfério Norte, a primavera chega em março e é conhecida como a estação do renascimento e da renovação após o longo e gélido inverno. Assim, é durante esse período que as plantas voltam a florescer, e os animais começam a procriar.\n\nOrigens pagãs\n\nNo passado, muitas culturas pagãs organizavam inúmeras festividades durante a primavera, justamente para celebrar esse renascimento e promover a fartura. Pois um desses festejos era dedicado à deusa da fertilidade “Eastre” — ou “Eostre”, nome que provavelmente deu origem à palavra Easter, que, por sua vez, significa Páscoa em inglês.",
                "Você já acendeu um palito de fósforo só para vê-lo queimando? Pois o pessoal do canal de YouTube HTD resolveu levar essa brincadeira a outro nível. Como é possível conferir no vídeo logo abaixo, eles enfileiraram 6 mil fósforos na forma de um quadrado e, com uma pequena chama, criaram uma impressionante reação em cadeia.\n\nPara quem espera ver o pequeno incêndio se alastrando em instantes, é bom avisar que a destruição dos palitos é bastante lenta. O processo todo, que foi registrado em quase 15 minutos de gravação, mostra que o fogo se alastra aos poucos, com um som cada vez mais ominoso à medida que mais e mais fósforos são atingidos.\n\nAo fim, tudo o que sobra são milhares de restos retorcidos e carbonizados de palitos, que permanecem queimando por um bom tempo com um relaxante som do que parece ser uma tranquila lareira.",
                "Vai  dizer que a sua produtividade não despenca quando você não dorme o suficiente! De acordo com Jill Duffy, do portal Fast Company, um novo estudo revelou que a falta de sono pode ser pior do que imaginamos — e que descansar apensas seis horas por noite durante duas semanas pode ter as mesmas consequências que ser forçado a permanecer acordado por 48 horas seguidas.\n\nSegundo Jill, o estudo foi conduzido com 48 adultos que, por duas semanas, tiveram o período de sono limitado a quatro, seis e oito horas por noite. Durante esses 14 dias, os participantes foram monitorados e realizaram atividades para testar seu tempo de reação e desempenho cognitivo a cada duas horas — a não ser que estivessem dormindo —, e alguns (azarados) foram mantidos acordados por três dias seguidos.",
                "A busca por vida alienígena acaba de ganhar mais um capítulo escrito por teóricos de conspirações: uma possível megaestrutura que “prova” que o Sol possui uma porta gigantesca para um mundo em seu interior mil vezes mais maciço que o nosso planeta.\n\nA imagem que traria a tal prova foi divulgada pelo Solar & Heliospheric Observatory (SOHO), da Nasa, e mostra anomalias na superfície da estrela. Elas são como uma linha branca, por onde passariam naves espaciais que entram e saem do Sol. Pelo menos é isso que jura o youtuber responsável pelo canal TheWatcher252.",
                "A o ler a pergunta no título deste texto, você pode pensar: “porque seria estranho dar aquele beijaço de olhos abertos, ué”, e, bem, é por isso também, mas tem mais. Quando o assunto é sexualidade e intimidade, sempre tem mais.\n\nO The Independent publicou, recentemente, o resultado de um estudo promovido pela Universidade de Londres e descobriu a grande verdade por trás dos olhinhos sempre fechados durante o beijo: quando está trabalhando enxergando coisas, o cérebro humano não consegue processar muito bem os estímulos provocados por outros sentidos.\n\nLógico que você come de olhos abertos e sente o gosto daquela macarronada mesmo assim, mas a questão aqui é mais com relação ao tato mesmo. Quanto menos enxergamos, mais aguçado o tato fica, e se tem uma coisa que todo mundo quer enquanto beija é justamente isso: sentir a coisa toda."};
        String[] dataCardArtigo = new String[]{"05-04-2014", "15-03-2014", "05-03-2015", "25-03-2014", "02-07-2014",
                "05-02-2013", "05-09-2014", "05-01-2014", "05-02-2015", "05-01-2015"};
        int[] fotoCardArtigo = new int[]{R.mipmap.artigo1, R.mipmap.artigo2, R.mipmap.artigo3, R.mipmap.artigo4, R.mipmap.artigo5, R.mipmap.artigo6, R.mipmap.artigo7, R.mipmap.artigo8, R.mipmap.artigo9, R.mipmap.artigo10};
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        Date[] dates = new Date[10];
        try {
            for (int i = 0; i < 10; i++) {
                date = sdf.parse(dataCardArtigo[i]);
                dates[i] = date;
            }
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        List<Artigo> listAux = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
            Artigo a = new Artigo(tituloCardArtigo[i % tituloCardArtigo.length], subTituloCardArtigo[i % subTituloCardArtigo.length], textoCardArtigo[i % textoCardArtigo.length], fotoCardArtigo[i % fotoCardArtigo.length]);
            listAux.add(a);
        }
        return (listAux);
    }

    public List<Video> getSetVideoList(int qtd) {

        String[] tituloCardVideo = new String[]{"Gallardo", "Vyron", "Corvette", "Pagani Zonda", "Porsche 911 Carrera", "BMW 720i", "DB77", "Mustang", "Camaro", "CT6"};
        String[] descricaoCardVideo = new String[]{"Lamborghini", " bugatti", "Chevrolet", "Pagani", "Porsche", "BMW", "Aston Martin", "Ford", "Chevrolet", "Cadillac"};
        String[] urlCardVideo = new String[]{"http://sample.vodobox.net/skate_phantom_flex_4k/skate_phantom_flex_4k.m3u8", "http://devimages.apple.com/iphone/samples/bipbop/gear1/prog_index.m3u8", "http://vevoplaylist-live.hls.adaptive.level3.net/vevo/ch1/appleman.m3u8", "http://sample.vodobox.net/skate_phantom_flex_4k/skate_phantom_flex_4k.m3u8", "http://devimages.apple.com/iphone/samples/bipbop/gear1/prog_index.m3u8", "http://vevoplaylist-live.hls.adaptive.level3.net/vevo/ch1/appleman.m3u8", "http://qthttp.apple.com.edgesuite.net/1010qwoeiuryfg/sl.m3u8", "http://playertest.longtailvideo.com/adaptive/captions/playlist.m3u8", "http://content.jwplatform.com/manifests/vM7nH0Kl.m3u8", "http://walterebert.com/playground/video/hls/sintel-trailer.m3u8", "http://cdn-fms.rbs.com.br/hls-vod/sample1_1500kbps.f4v.m3u8", "http://www.nacentapps.com/m3u8/index.m3u8"};
        int[] fotoCardVideo = new int[]{R.mipmap.artigo1, R.mipmap.artigo2, R.mipmap.artigo3, R.mipmap.artigo4, R.mipmap.artigo5, R.mipmap.artigo6, R.mipmap.artigo7, R.mipmap.artigo8, R.mipmap.artigo9, R.mipmap.artigo10};
        int[] positon = new int[]{0,1,2,3,4,5,6,7,8,9};
        String[]tags = new String[]{"klm,opk,okp,k","kml,k,okp,kl","opk,kml,kl,kj","a1,ao,m,a","a5,ao,m,a","a6,ao,m,a","a7,ao,m,a","a8,ao,m,a","a9,ao,m,a","a10,ao,m,a",};

        List<Video> listAux = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
            Video v = new Video(tituloCardVideo[i % tituloCardVideo.length], descricaoCardVideo[i % descricaoCardVideo.length], urlCardVideo[i % urlCardVideo.length], fotoCardVideo[i % fotoCardVideo.length], tags[i % tags.length], positon[i % positon.length]);
            listAux.add(v);
        }
        return (listAux);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView;
        MenuItem item = menu.findItem(R.id.action_searchable_activity);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            searchView = (SearchView) item.getActionView();
        } else {
            searchView = (SearchView) MenuItemCompat.getActionView(item);
        }

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getResources().getString(R.string.search_hint));

        return true;
    }
}
