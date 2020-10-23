package Model;

public enum Articles {

    POTIRON(1, "Potiron", "https://i.f1g.fr/media/madame/1200x851_crop/sites/default/files/img/2020/01/differences-entre-potiron-et-citrouille.jpg", 1.15),
    BANNANE(2, "Bannane", "https://gourmandiz.dhnet.be/app/uploads/2018/11/bananes.jpg", 2),
    POIRE(3, "Poire", "https://larecette.net/wp-content/uploads/2019/02/poires.jpg", 0.2),
    POMME(4, "Pomme", "https://s3-eu-west-1.amazonaws.com/images-ca-1-0-1-eu/tag_photos/extralarge/111/pommes-flickr-2861818327_1bd4b4bfdb_b.jpg", 0.2),
    NOIX(5, "Noix", "https://www.notretemps.com/cache/com_zoo_images/0a/noix-dietetique_151cae55751b8bb260984d3bbebd055c.jpg", 3),
    PATTATE(6, "Pattate", "https://static-wp.alternatif-bien-etre.com/alternatif-bien-etre.com/wp-content/uploads/2019/08/06140610/shutterstock_3476302911.jpg", 0.5);

    public int id;
    public String libelle;
    public String imageURL;
    public double prix;

    Articles(int id, String libelle, String imageURL, double prix){
        this.id = id;
        this.libelle = libelle;
        this.imageURL = imageURL;
        this.prix = prix;
    }

    static public Articles get(int id){
        for (Articles a : Articles.values()) {
            if(a.id == id){
                return a;
            }
        }
        throw new RuntimeException("Id article inconnu");
    }
}
