package entity;

import entity.Buyer;
import entity.Product;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-29T19:03:37")
@StaticMetamodel(History.class)
public class History_ { 

    public static volatile SingularAttribute<History, Product> product;
    public static volatile SingularAttribute<History, Integer> num;
    public static volatile SingularAttribute<History, Long> id;
    public static volatile SingularAttribute<History, Date> takeOn;
    public static volatile SingularAttribute<History, Buyer> buyer;

}