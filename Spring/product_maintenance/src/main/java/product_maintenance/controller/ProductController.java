package product_maintenance.controller;

import lombok.AllArgsConstructor;
import product_maintenance.entity.Product;
import product_maintenance.service.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/products")
    public String displayProducts(Model model){
        model.addAttribute("products",
                productService.getAllProducts());
        return "products";
    }

    @GetMapping("/new")
    public String createProductForm(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("message", "");
        return "newProduct";
    }
    @PostMapping("/")
    public String saveProduct(@ModelAttribute("product") Product product, Model model){
        String direct = "redirect:/";
        String message = "";
        if (productService.getProductById(product.getId()) == null){
            productService.saveProduct(product);
        }
        else{
            message = "ID existed!";
            direct = "newProduct";
        }
        model.addAttribute("message", message);
        return direct;
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable String id,
                                  Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "editProduct";
    }

    @PostMapping("/{id}")
    public String updateProduct(@PathVariable String id,
                                @ModelAttribute("product") Product product){
        Product existedProduct = productService.getProductById(id);
        existedProduct.setId(id);
        existedProduct.setDescription(product.getDescription());
        existedProduct.setPrice(product.getPrice());
        productService.updateProduct(existedProduct);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String deleteProduct(@PathVariable String id){
        productService.deleteProductById(id);
        return "redirect:/";
    }
}