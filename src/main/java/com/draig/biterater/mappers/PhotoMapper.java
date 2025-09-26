package com.draig.biterater.mappers;

import com.draig.biterater.domain.dtos.PhotoDto;
import com.draig.biterater.domain.entities.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PhotoMapper {
    PhotoDto toDto(Photo photo);

}
