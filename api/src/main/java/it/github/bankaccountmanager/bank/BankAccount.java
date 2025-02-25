/*
 * MIT License
 *
 * Copyright (c) 2024 Giuseppe Calabrese
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package it.github.bankaccountmanager.bank;

import it.github.bankaccountmanager.user.Client;

/**
 * @author Giuseppe Calabrese
 * @lastModified 25-01-2024 - Code fixing.
 */

public class BankAccount {
  private double saldo;
  private int deposita;
  private int prelievo;
  private double saldomassimo;

  /**
   * @param saldo the initial balance of the account
   * @param proprietario the owner of the account
   * @param contoMax the maximum balance of the account
   * @throws Exception if the initial balance is negative
   *
   * The initial balance of the account. Must be a positive number.
   */



  public BankAccount(double saldo, Client proprietario, double contoMax) throws Exception {
    if(saldo < 0) {
      System.out.println();
      throw new Exception("It is not possible to create current accounts with a negative balance!" + "\n"
        + "\n" + "Be very careful"  + "\n" + "\n" + "The incorrect balance is as follows: "
        + saldo);
    }
    this.saldo = saldo;
    this.saldomassimo = contoMax;
  }

  public double get_saldo() { return saldo; }

  public void set_deposita(int deposita) {
    this.deposita = deposita;
  }

  public int depositoTOT() {
    deposita = (int) (deposita + saldo);
    saldo = deposita;
    return deposita;
  }

  public void set_prelievo(int prelievo) { this.prelievo = prelievo; }

  public int prelievo_Aggiornato() {
    saldo = (int) saldo - prelievo;
    return (int) saldo;
  }

  public double get_saldo_massimo() { return saldomassimo; }

}

