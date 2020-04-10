package Dao;

import model.Customer;

import java.util.*;

public class CustomerDao {
    private static final Map<Integer, Customer> listCUSTOMER = new HashMap<Integer, Customer>();

    static {
        initCustomers();
    }

    private static void initCustomers() {
        Customer cus1 = new Customer(1, "Trần Ngọc Tân", "012423423", "tan@gmail.com");
        Customer cus2 = new Customer(2, "Phạm Minh Hưng", "012423423", "hung@gmail.com");
        Customer cus3 = new Customer(3, "Nguyễn Đình Hòa", "012423423", "hoa@gmail.com");
        Customer cus4 = new Customer(4, "Phạm Thái Cường", "012423423", "cuong@gmail.com");
        listCUSTOMER.put(cus1.getId(), cus1);
        listCUSTOMER.put(cus2.getId(), cus2);
        listCUSTOMER.put(cus3.getId(), cus3);
        listCUSTOMER.put(cus4.getId(), cus4);
    }

    //Viết phương thức xử lý get thông tin chi tiết của một customer theo id
    public static Customer getCustomer(int customerId) {
        return listCUSTOMER.get(customerId);
    }

    //Viết phương thức thêm mới 1 customer
    public static void addCustomer(Customer customer) {
        listCUSTOMER.put(customer.getId(), customer);
    }

    //Viết phương thức update thông tin 1 customer
    public static void updateAndCreateCustomer(Customer customer) {
        listCUSTOMER.put(customer.getId(), customer);
    }

    //viết phương thức delete 1 customer theo id
    public static void deleteCustomer(int customerId) {
        listCUSTOMER.remove(customerId);
    }

    //Viết phương thức lấy ra tất cả danh sách customer
    public static List<Customer> getAllCustomer() {
        Collection<Customer> c = listCUSTOMER.values();
        List<Customer> list = new ArrayList<Customer>();
        list.addAll(c);
        return list;
    }
}
