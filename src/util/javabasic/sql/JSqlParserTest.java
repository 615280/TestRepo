package util.javabasic.sql;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.ItemsListVisitor;
import net.sf.jsqlparser.expression.operators.relational.MultiExpressionList;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SubSelect;
import net.sf.jsqlparser.util.AddAliasesVisitor;
import net.sf.jsqlparser.util.SelectUtils;

public class JSqlParserTest {
	
	public static void main(String[] args) throws JSQLParserException {
		
		//SELECT columnName, a + b FROM mytable
		Select select = SelectUtils.buildSelectFromTableAndExpressions(
				new Table("mytable"), "columnName", "a+b");
		System.out.println(select.toString());

		Insert insert = (Insert)CCJSqlParserUtil.parse("insert into mytable (col1) values (1)");
		System.out.println(insert.toString());

		//adding a column
		insert.getColumns().add(new Column("col2"));
		//adding a value using a visitor
		insert.getItemsList().accept(new ItemsListVisitor() {
		    public void visit(SubSelect subSelect) {
		    throw new UnsupportedOperationException("Not supported yet.");
		    }
		    public void visit(ExpressionList expressionList) {
		    expressionList.getExpressions().add(new LongValue(5));
		    }
		    public void visit(MultiExpressionList multiExprList) {
		    throw new UnsupportedOperationException("Not supported yet.");
		    }
		});
		System.out.println(insert.toString());

		//adding another column
		insert.getColumns().add(new Column("col3"));

		//adding another value (the easy way)
		((ExpressionList)insert.getItemsList()).getExpressions().add(new LongValue(10));

		System.out.println(insert.toString());
		
	}
}
