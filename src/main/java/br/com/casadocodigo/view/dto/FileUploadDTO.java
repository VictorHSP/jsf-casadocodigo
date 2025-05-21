package br.com.casadocodigo.view.dto;

public record FileUploadDTO(byte[] photo, String fileName, String contentType, Long size) { }
