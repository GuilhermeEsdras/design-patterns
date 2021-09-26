import { baseBudgetHandler } from "./base-budget-handler";
import { CustomerBudget } from "./customer-budget";

export class SellerBudgetHandler extends baseBudgetHandler {
  handle(budget: CustomerBudget): CustomerBudget {
    if (budget.total <= 1000) {
      console.log('O vendedor tratou o orçamento');
      budget.approved = true;
      return budget;
    }

    return super.handle(budget);
  }
}