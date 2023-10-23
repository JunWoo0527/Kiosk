package Kiosk;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Order {

    ArrayList<Product> orderList = new ArrayList<>();
    ArrayList<Product> sellProduct = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int check;

    int watNum = 1;
    double totalMoney;
    double sellMoney = 0;



    public void setOrderList(Product product){
        orderList.add(product);
    }

    public void  totalOderList(){
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();

        System.out.println("[ Orders ]");

        Set<Product> setOrderList = new LinkedHashSet<>(orderList);
        ArrayList<Product> reorderList = new ArrayList<>(setOrderList);
        for (int i = 0; i < reorderList.size() ; i++){
            System.out.printf("%-25s",reorderList.get(i).getName());
            System.out.println("| W " + reorderList.get(i).getPrice() + " | " + Collections.frequency(orderList,reorderList.get(i))+ "개 | " + reorderList.get(i).getDescription());
            totalMoney += reorderList.get(i).getPrice() * Collections.frequency(orderList,reorderList.get(i));
        }
        System.out.println();

        System.out.println("[ Total ]");
        System.out.println("W " + Math.floor(totalMoney*10)/10);
        System.out.println();


        System.out.println("1. 주문          2. 메뉴판");
        System.out.println();
        check = sc.nextInt();

        if (check == 1){
            System.out.println("주문이 완료되었습니다.!");
            System.out.println();

            System.out.println("대기번호는 [ " + watNum + " ] 번 입니다.");
            System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
            System.out.println();
            watNum += 1;
            sellMoney += Math.floor(totalMoney*10)/10;;
            for (Product i : orderList){
                sellProduct.add(i);
            }

            totalMoney = 0;
            orderList.clear();

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } else if (check == 2) {
            totalMoney = 0;
        } else {
            System.out.println("1 혹은 2만 입력해주세요");
            System.out.println();
        }

    }

    public void cancleOrder(){

        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인           2. 취소");
        System.out.println();

        check = sc.nextInt();
        if (check == 1) {
            System.out.println("진행하던 주문이 취소되었습니다.");
            System.out.println();
            orderList.clear();
        } else if (check == 2) {
        } else {
            System.out.println("1 혹은 2만 입력해주세요");
            System.out.println();

        }
    }

    public void totalSell(){
        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        System.out.println();

        for (int i=0; i < sellProduct.size(); i++){
            System.out.printf("%-25s",sellProduct.get(i).getName());
            System.out.println("| W " + sellProduct.get(i).getPrice());
        }
        System.out.println();
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.println("현재까지 총 판매된 금액은 [ W " + sellMoney + " ] 입니다.");
        System.out.println();

        System.out.println("1. 돌아가기");
        System.out.println();
        check = sc.nextInt();

    }
}

