package com.project.adoption.pet.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {
    public static final String MSG_SAVE_SUCCESSFULLY = "Mascota con el nombre %s guardado exitosamente con el id %s";
    public static final String MSG_UPDATE_SUCCESSFULLY = "Se actualizó con exitó la mascota dcon id %s";
    public static final String MSG_UPDATE_ERROR = "Error al actualizar la mascota de id %s";
    public static final String MSG_PET_NOT_FOUND = "La mascota de id %S no existe";
    public static final String MSG_PET_NOT_GET = "No se pudo obtener la mascota con id %s";
    public static final String MSG_PET_NOT_DELETE = "No se pudo eliminar la mascota de id %s";
    public static final String MSG_PET_DELETE = "Se eliminó la mascota con id %s";
    public static final String MSG_NOT_COMMUNICATE_WITH_PET_TYPE = "Algo falló al comunicarnos con nuestro servicio de tipo de mascota, intenta mas tarde";
    public static final String MSG_PET_NOT_SAVE = "No se pudo guardar la mascota con nombre %s";
    public static final String MSG_PET_TYPE_NOT_EXIST = "El tipo de mascota con id %s no existe, por favor creelo antes de asignarle una mascota";
    public static final String MSG_PETS_AVAILABILITY_NOT_GET = "No se pudieron obtener las mascotas disponibles, intenta mas tarde";
    public static final String ENTITY_PACKAGE = "com.project.adoption.pet.domain.entities";
    public static final String REPOSITORY_PACKAGE = "com.project.adoption.pet.infrastructure.persistence";
    public static final String INTERNAL_ERROR_IN_PET_TYPE = "Error interno en el servicio de pet-type, intenta mas tarde";
    public static final String MSG_PETS_NOT_GET = "Nose pudo obtener las mascotas correspondientes a los id";
}
