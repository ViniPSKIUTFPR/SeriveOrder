package utfpr.arq.Order.Service.management.dto;

import java.util.UUID;

public record EmailDTO(UUID userID, String emailTo, String subject, String text) {}