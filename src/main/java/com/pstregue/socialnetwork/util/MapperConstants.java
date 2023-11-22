package com.pstregue.socialnetwork.util;

import org.mapstruct.factory.Mappers;

public class MapperConstants {
    public static final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    public static final PostMapper postMapper = Mappers.getMapper(PostMapper.class);
}
