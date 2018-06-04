package dao;

import entity.ApAccountPackage;

public interface ApAccountPackageMapper {
    int deleteByPrimaryKey(Integer accountPackageId);

    int insert(ApAccountPackage record);

    int insertSelective(ApAccountPackage record);

    ApAccountPackage selectByPrimaryKey(Integer accountPackageId);

    int updateByPrimaryKeySelective(ApAccountPackage record);

    int updateByPrimaryKey(ApAccountPackage record);
}