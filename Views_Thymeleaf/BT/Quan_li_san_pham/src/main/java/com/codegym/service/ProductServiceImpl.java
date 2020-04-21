package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> listProduct;

    static {
        listProduct = new HashMap<>();
        listProduct.put(1,new Product(1,"VIPPRO9X",99999, "https://scontent.fdad3-1.fna.fbcdn.net/v/t1.0-9/88990161_1039883029714542_8936343328127975424_n.jpg?_nc_cat=108&_nc_sid=7aed08&_nc_oc=AQmtTe-Hh9HYTazGvX4ENW6SlgwSllkLLp_dZVz6jU-bdaeaIH2UI1SjnQwBRzZqcxc&_nc_ht=scontent.fdad3-1.fna&oh=0c8cbdaf657eb84c1de59d023435514d&oe=5EBE6598","VN"));
        listProduct.put(2,new Product(2,"TANNONTRE",555555, "https://scontent.fdad3-2.fna.fbcdn.net/v/t1.0-9/89033637_1041198676249644_5752073906521374720_n.jpg?_nc_cat=104&_nc_sid=7aed08&_nc_oc=AQldI5gcRQqIx5zRTTFyc-bF--Vde2GiZAAOkHc7gt6VhiEpXnb56Wexs5PpR4JaBNw&_nc_ht=scontent.fdad3-2.fna&oh=53055773d17ea176ca23cc8a490350ae&oe=5EC064D1","QN"));
        listProduct.put(3,new Product(3,"HOALAODAI",77777, "https://scontent.fdad3-3.fna.fbcdn.net/v/t1.0-9/93314546_1071495779886600_5416727013283069952_n.jpg?_nc_cat=109&_nc_sid=85a577&_nc_oc=AQkPETw4JbYTl9-Yq_CCvYKPxGz_RnG2elPKk7KPn_iPm5-V8eluxLI68wPE92LyqQc&_nc_ht=scontent.fdad3-3.fna&oh=0aa14a46ddfc8425b7d80b6879113b36&oe=5EBFC1E8","GL"));
        listProduct.put(4,new Product(4,"CUONGSADI",88888888, "https://scontent.fdad3-1.fna.fbcdn.net/v/t1.0-9/s960x960/73349250_3043356315890383_5043445461352972288_o.jpg?_nc_cat=106&_nc_sid=85a577&_nc_oc=AQn9QxnPYu2TDqx93c1taKeH6gfeAL44ksTbEO-kdzP8_VWMlnfYjwdG0nrP4APW8Qs&_nc_ht=scontent.fdad3-1.fna&_nc_tp=7&oh=99692d6eeb5c74ad353136069eb47ce9&oe=5EC11EC2","CS"));

    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(listProduct.values());
    }

    @Override
    public void save(Product product) {
        listProduct.put(product.getId(),product);

    }

    @Override
    public Product findById(int id) {
        return listProduct.get(id);
    }

    @Override
    public void update(int id, Product product) {
        listProduct.put(id,product);

    }

    @Override
    public void remove(int id) {
        listProduct.remove(id);

    }
}