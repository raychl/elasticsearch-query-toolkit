package org.es.test.query;

import org.es.sql.dsl.bean.ElasticSqlParseResult;
import org.es.sql.dsl.parser.ElasticSql2DslParser;
import org.junit.Test;


public class SqlParserOrderByTest {
    @Test
    public void testParseEqExpr() {
        String sql = "select id,status from index.order order by price asc,id desc,lastUpdateTime asc";
        ElasticSql2DslParser sql2DslParser = new ElasticSql2DslParser();
        ElasticSqlParseResult parseResult = sql2DslParser.parse(sql);

        System.out.println(parseResult.toDsl());

//        SortBuilder targetSort = SortBuilders.fieldSort("price").order(SortOrder.ASC);
//
//
//        Assert.assertEquals(parseResult.getOrderBy().get(0).toString(), targetSort.toString());
//        targetSort = SortBuilders.fieldSort("id").order(SortOrder.DESC);
//        Assert.assertEquals(parseResult.getOrderBy().get(1).toString(), targetSort.toString());
//        targetSort = SortBuilders.fieldSort("lastUpdateTime").order(SortOrder.ASC);
//        Assert.assertEquals(parseResult.getOrderBy().get(2).toString(), targetSort.toString());
//
//        druid = "select id,status from index.order order by nvl(price, 0) asc";
//        sql2DslParser = new ElasticSql2DslParser();
//        parseResult = sql2DslParser.parse(druid);
//        targetSort = SortBuilders.fieldSort("price").order(SortOrder.ASC).missing(0);
//        Assert.assertEquals(parseResult.getOrderBy().get(0).toString(), targetSort.toString());
//
//        druid = "select id,status from index.order order by nvl(product.price, 0) asc";
//        sql2DslParser = new ElasticSql2DslParser();
//        parseResult = sql2DslParser.parse(druid);
//        targetSort = SortBuilders.fieldSort("product.price").order(SortOrder.ASC).missing(0);
//        Assert.assertEquals(parseResult.getOrderBy().get(0).toString(), targetSort.toString());
//
//        druid = "select id,status from index.order order by nvl($product.price, 0) asc";
//        sql2DslParser = new ElasticSql2DslParser();
//        parseResult = sql2DslParser.parse(druid);
//        targetSort = SortBuilders.fieldSort("product.price").order(SortOrder.ASC).missing(0).setNestedPath("product");
//        Assert.assertEquals(parseResult.getOrderBy().get(0).toString(), targetSort.toString());
//
//
//        druid = "select id,status from index.order order by nvl(product.price, 0) asc";
//        sql2DslParser = new ElasticSql2DslParser();
//        parseResult = sql2DslParser.parse(druid);
//        targetSort = SortBuilders.fieldSort("product.price").order(SortOrder.ASC).missing(0);
//        Assert.assertEquals(parseResult.getOrderBy().get(0).toString(), targetSort.toString());
//
        sql = "select id,status from index.order order by product.price asc, $productTags.sortNo desc";
        sql2DslParser = new ElasticSql2DslParser();
        parseResult = sql2DslParser.parse(sql);

        System.out.println(parseResult.toDsl());

//        targetSort = SortBuilders.fieldSort("product.price").order(SortOrder.ASC);
//        Assert.assertEquals(parseResult.getOrderBy().get(0).toString(), targetSort.toString());
//        targetSort = SortBuilders.fieldSort("productTags.sortNo").order(SortOrder.DESC).setNestedPath("productTags");
//        Assert.assertEquals(parseResult.getOrderBy().get(1).toString(), targetSort.toString());
    }
}
