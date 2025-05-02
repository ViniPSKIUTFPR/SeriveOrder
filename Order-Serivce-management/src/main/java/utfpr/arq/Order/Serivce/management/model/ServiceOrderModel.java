package utfpr.arq.Order.Serivce.management.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiceOrderModel {
    private String id;
    private String customerName;
    private String status;
}
