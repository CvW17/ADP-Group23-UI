//Bill.java
//Entity for Bill
//Author: Cameron van Wyk(219088470)

package za.ac.cput.models.entity.product;

public class Bill
{
    private String billID;
    private double subTotal, tax, total;

    private Bill()
    {

    }

    private Bill(Builder builder)
    {
        this.billID = builder.billID;
        this.subTotal = builder.subTotal;
        this.tax = builder.tax;
        this.total = builder.total;
    }

    public String getBillID()
    {
        return billID;
    }

    public double getSubTotal()
    {
        return subTotal;
    }

    public double getTax()
    {
        return tax;
    }

    public double getTotal()
    {
        return total;
    }

    @Override
    public String toString()
    {
        return "Bill{" +
                "billID='" + billID + '\'' +
                ", subTotal=" + subTotal +
                ", tax=" + tax +
                ", total=" + total +
                '}';
    }

    public static class Builder
    {
        private String billID;
        private double subTotal, tax, total;

        public Builder setBillID(String billID)
        {
            this.billID = billID;
            return this;
        }

        public Builder setSubTotal(double subTotal)
        {
            this.subTotal = subTotal;
            return this;
        }

        public Builder setTax(double tax)
        {
            this.tax = tax;
            return this;
        }

        public  Builder setTotal(double total)
        {
            this.total = total;
            return this;
        }

        public Bill build()
        {
            return new Bill(this);
        }

        public Builder copy(Bill bill)
        {
            this.billID = bill.billID;
            this.subTotal = bill.subTotal;
            this.tax = bill.tax;
            this.total = bill.total;

            return this;
        }
    }
}
