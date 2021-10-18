/**
 *  Name: Antin Williams
 *  Student Number: 219212058
 *  Group: 23
 */

package za.ac.cput.models.factory.product;

import za.ac.cput.models.entity.product.Product;
import za.ac.cput.util.GenericHelper;

public class ProductFactory {
    public static Product build (
            String supplierId,
            String name,
            String price
    ) {
        String productId = GenericHelper.generateID();

        return new Product.Builder()
                .setProductId(productId)
                .setSupplierId(supplierId)
                .setName(name)
                .setPrice(price)
                .Build();
    }
}
