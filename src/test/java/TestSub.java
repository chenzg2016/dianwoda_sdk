import org.junit.Test;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:
 * @Date:2017/8/28 下午1:41
 * @package:PACKAGE_NAME
 * @Modified By:
 */
public class TestSub {



    @Test
    public void  testSub(){
        int n =10;
        int tem = n;
        StringBuffer buff = new StringBuffer();
        buff.append(tem+"-");
        for (int i = 1;i<((n/2)+1);i++){
            int sub = n-2*i;
            if (sub != 0){
                buff.append(sub+"-");
                tem -= n-2*i ;
            }
        }
        String s = buff.toString().substring(0,buff.toString().lastIndexOf("-"));
        System.out.println(s+" = "+tem);

        int j =1;
        tem = n;
        buff = new StringBuffer();
        buff.append(tem+"-");
        while (j<((n/2)+1)){
            int sub = n-2*j;
            if (sub != 0){
                buff.append(sub+"-");
                tem -= n-2*j ;
            }
            j++;
        }
        s = buff.toString().substring(0,buff.toString().lastIndexOf("-"));
        System.out.println(s+" = "+tem);

    }


    @Test
    public void searchN(){
        int i,sum=0;
        int n = 1;


//        for (i)

        while(!(n%11 == 0 && n%13 == 0 && n%5 == 1))
        {
            n++;
        }

        System.out.println("n="+n);

// 从1开始，求所有不能被3整除后不能被5整除的数之和，
// 直到出现这样的一个数:既能被11整除，又能被13整除，且除以5余1
        for(i=1;;i++) {
            if((i%3 !=0) && (i%5 != 0)) {
                sum += i;
            }
            if ((i%11 == 0) && (i%13 == 0)&& (i%5 == 1)){
                break;
            }
        }

        System.out.println("sum="+sum);
        System.out.println(286%5);
    }

}
